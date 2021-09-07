package com.goldencodes.zbattle.util;

import com.goldencodes.zbattle.ZBattlePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class UtilChat {

    private static final String PLUGIN_PREFIX = "§7[§aZBattle§7]";

    public static String translate(String str) {
        return ChatColor.translateAlternateColorCodes('§', str);
    }

    public static void tell(Player player, String message) {
        player.sendMessage(translate(message));
    }

    public static void tellConsole(String message) {
        ConsoleCommandSender console = ZBattlePlugin.getInstance().getServer().getConsoleSender();
        console.sendMessage(translate(message));
    }

    public static void announceMessage(String message) {
        Bukkit.getServer().broadcastMessage(translate(message));
    }
}
