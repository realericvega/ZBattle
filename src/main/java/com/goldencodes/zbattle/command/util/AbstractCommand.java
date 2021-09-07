package com.goldencodes.zbattle.command.util;

import com.goldencodes.zbattle.command.system.IZBattleCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.*;

import java.lang.reflect.Field;
import java.util.List;

public abstract class AbstractCommand implements CommandExecutor, TabExecutor, IZBattleCommand {

    private CommandMap commandMap;

    private final String COMMAND;

    private final String PERMISSION;
    private final String PERMISSION_MESSAGE;
    private final String DESCRIPTION;
    private final String USAGE;
    private final List<String> ALIASES;

    public AbstractCommand(String command) {
        this(command, null, null, null, null, null);
    }

    public AbstractCommand(String command, String permission) {
        this(command, permission, null, null, null, null);
    }

    public AbstractCommand(String command, String permission, List<String> aliases) {
        this(command, permission, null, null, null, aliases);
    }

    public AbstractCommand(String command, String permission, String usage, List<String> aliases) {
        this(command, permission, usage, null, null, aliases);
    }

    public AbstractCommand(String command, String permission, String usage, String permissionMessage, List<String> aliases) {
        this(command, permission, usage, permissionMessage, null, aliases);
    }

    public AbstractCommand(String command, String permission, String usage, String permissionMessage, String description, List<String> aliases) {
        this.COMMAND = command;
        this.PERMISSION = permission;
        this.USAGE = usage;
        this.PERMISSION_MESSAGE = permissionMessage;
        this.DESCRIPTION = description;
        this.ALIASES = aliases;
    }

    private CommandMap getCommandMap() {
        if (this.commandMap == null) {
            try {

                Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");

                field.setAccessible(true);

                return this.commandMap = (CommandMap) field.get(Bukkit.getServer());

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return this.commandMap;
        }
        return getCommandMap();
    }

    public void registerCommand() {
        ReflectionCommand reflectionCommand = new ReflectionCommand(this.COMMAND);

        if (this.PERMISSION != null) reflectionCommand.setPermission(this.PERMISSION);
        if (this.PERMISSION_MESSAGE != null) reflectionCommand.setPermissionMessage(this.PERMISSION_MESSAGE);
        if (this.DESCRIPTION != null) reflectionCommand.setDescription(this.DESCRIPTION);
        if (this.USAGE != null) reflectionCommand.setUsage(this.USAGE);
        if (this.ALIASES != null) reflectionCommand.setAliases(this.ALIASES);

        getCommandMap().register("", reflectionCommand);
        reflectionCommand.setExecutor(this);
    }

    public void registerAllCommands() {

    }

    @Override
    public abstract void run(CommandSender sender, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        run(sender, args);
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
