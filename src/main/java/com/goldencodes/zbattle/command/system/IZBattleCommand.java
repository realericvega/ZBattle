package com.goldencodes.zbattle.command.system;

import org.bukkit.command.CommandSender;

public interface IZBattleCommand {

    /**
     *
     * @param sender - sender represents the user executing the command
     * @param args - args represent the extra options of the command
     */
    void run(CommandSender sender, String[] args);
}
