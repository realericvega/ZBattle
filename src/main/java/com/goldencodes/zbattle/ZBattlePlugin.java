package com.goldencodes.zbattle;

import com.goldencodes.zbattle.manager.BlockManager;
import com.goldencodes.zbattle.manager.PhaseManager;
import com.goldencodes.zbattle.manager.UserManager;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZBattlePlugin extends JavaPlugin {

    private Location spawn;

    private static UserManager userManager;
    private static BlockManager blockManager;
    private static PhaseManager phaseManager;

    @Override
    public void onEnable() {

    }

    private void runDiagnosticTests() {
        // This method sends messages to the console whenever a phase is starting, ending, or active
        // If an error has occurred, this method ensures that we know about it
    }

    public boolean isSpawnSet() {
        return true;
    }

    public static UserManager getUserManager() {
        return userManager;
    }

    public static BlockManager getBlockManager() {
        return blockManager;
    }

    public static PhaseManager getPhaseManager() {
        return phaseManager;
    }

    @Override
    public void onDisable() {

    }
}
