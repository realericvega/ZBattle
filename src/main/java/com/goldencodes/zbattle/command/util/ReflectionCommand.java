package com.goldencodes.zbattle.command.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ReflectionCommand extends Command  {

    private AbstractCommand exe;

    public ReflectionCommand(String command) {
        super(command);
    }

    public void setExecutor(AbstractCommand exe) {
        this.exe = exe;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        return false;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return super.tabComplete(sender, alias, args);
    }
}
