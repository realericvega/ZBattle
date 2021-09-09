package com.goldencodes.zbattle.listener.game;

import com.goldencodes.zbattle.util.UtilPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashSet;
import java.util.UUID;

public class DeathListener implements Listener {

    private HashSet<UUID> _playersDead = new HashSet<UUID>();

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDeath(PlayerDeathEvent event) {

        _playersDead.add(event.getEntity().getPlayer().getUniqueId());

        UtilPlayer.setSpectating(event.getEntity().getPlayer(),
                (event.getEntity().getKiller() != null ? event.getEntity().getKiller() : null));
    }
}
