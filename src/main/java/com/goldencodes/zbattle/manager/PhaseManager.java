package com.goldencodes.zbattle.manager;

import com.goldencodes.zbattle.ZBattlePlugin;
import com.goldencodes.zbattle.manager.phase.PreGamePhase;
import com.goldencodes.zbattle.manager.phase.util.Phase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;

public class PhaseManager {

    private static PhaseManager instance;

    private final static int MAX_PLAYERS = 32;
    private final static int MIN_PLAYERS = 8;

    private Location spawn;

    private Phase currentPhase;

    public PhaseManager() {
        setPhase(new PreGamePhase());
    }

    public boolean isInPhase(Class<? extends Phase> phaseClass) {
        return currentPhase.getClass().equals(phaseClass);
    }

    public void nextPhase() {
        setPhase(currentPhase.getNextPhase());
    }

    private void setPhase(Phase phase) {
        if (currentPhase != null) {
            currentPhase.onDisable();
        }
        HandlerList.unregisterAll(currentPhase);

        currentPhase = phase;
        Bukkit.getPluginManager().registerEvents(currentPhase, ZBattlePlugin.getInstance());
        currentPhase.onEnable();
    }

    public static PhaseManager getInstance() {
        return instance;
    }

    public static int getMaxPlayers() {
        return MAX_PLAYERS;
    }

    public static int getMinPlayers() {
        return MIN_PLAYERS;
    }

    public Location getSpawn() {
        return spawn;
    }
}
