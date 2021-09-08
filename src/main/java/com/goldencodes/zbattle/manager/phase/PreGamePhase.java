package com.goldencodes.zbattle.manager.phase;

import com.goldencodes.zbattle.ZBattlePlugin;
import com.goldencodes.zbattle.manager.PhaseManager;
import com.goldencodes.zbattle.manager.phase.util.Phase;
import com.goldencodes.zbattle.util.UtilPlayer;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PreGamePhase extends Phase {


    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent event) {
        if (!ZBattlePlugin.getInstance().isSpawnSet() && !ZBattlePlugin.getUserManager().isHost(event.getUniqueId())) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, UtilPlayer.translate("§6You can't join yet!"));
        }

        if (ZBattlePlugin.getUserManager().getPlayers().stream().filter(player -> !player.isHost()).count() >= PhaseManager.getMaxPlayers()) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, UtilPlayer.translate("§6Game is full!"));
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (ZBattlePlugin.getInstance().isSpawnSet()) {
            event.getPlayer().teleport(PhaseManager.getInstance().getSpawn());

            if (!ZBattlePlugin.getUserManager().isHost(event.getPlayer().getUniqueId())) {
                event.getPlayer().setGameMode(GameMode.ADVENTURE);
                event.getPlayer().getInventory().clear();
                event.getPlayer().getInventory().setArmorContents(new ItemStack[]{null, null, null, null});
                event.getPlayer().getActivePotionEffects()
                        .forEach(effect -> event.getPlayer().removePotionEffect(effect.getType()));
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        event.setCancelled(!ZBattlePlugin.getUserManager().getPlayer(event.getPlayer()).isHost());
    }

    @Override
    public Phase getNextPhase() {
        return new TeleportPhase();
    }
}
