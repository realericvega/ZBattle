package com.goldencodes.zbattle.util;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.EntityTracker;
import net.minecraft.server.v1_8_R3.EntityTrackerEntry;
import org.bukkit.GameMode;
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
}
