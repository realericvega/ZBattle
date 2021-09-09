package com.goldencodes.zbattle.util;

import com.goldencodes.zbattle.ZBattlePlugin;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.EntityTracker;
import net.minecraft.server.v1_8_R3.EntityTrackerEntry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class UtilPlayer {

    private static Random RANDOM = new Random();

    public static void setSpectating(Player player, Entity ent) {
        if (!ent.isValid()) return;

        player.setGameMode(GameMode.SPECTATOR);

        if (player.getSpectatorTarget() != null) {
            player.setSpectatorTarget(null);
        }

        player.teleport(ent);

        if (isTracked(player, ent)) {

            player.setSpectatorTarget(ent);

        } else {
            new BukkitRunnable() {
                public void run() {
                    setSpectating(player, ent);
                }
            }.runTaskLater(UtilServer.getPlugin(), 1);
        }
    }

    /**
     * Returns true if the given player is tracking the given target, meaning that the player
     * got the entity loaded and knows about the entity.
     */
    public static boolean isTracked(Player player, Entity target) {

        EntityPlayer ep = ((CraftPlayer) player).getHandle();

        EntityTracker tracker = ep.u().getTracker();
        EntityTrackerEntry entry = tracker.trackedEntities.get(target.getEntityId());

        return entry.trackedPlayers.contains(ep);
    }

    private static final String PLUGIN_PREFIX = "§7[§aZBattle§7]";

    public static String translate(String str) {
        return ChatColor.translateAlternateColorCodes('§', str);
    }

    public static void tell(Player player, String message) {
        player.sendMessage(translate(message));
    }

    public static void tellConsole(String message) {
        ConsoleCommandSender console = UtilServer.getPlugin().getServer().getConsoleSender();
        console.sendMessage(translate(message));
    }

    public static void announceMessage(String message) {
        Bukkit.getServer().broadcastMessage(translate(message));
    }
}
