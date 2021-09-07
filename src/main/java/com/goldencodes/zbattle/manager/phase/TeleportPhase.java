package com.goldencodes.zbattle.manager.phase;

import com.goldencodes.zbattle.manager.phase.util.Phase;

public class TeleportPhase extends Phase {

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public Phase getNextPhase() {
        return new GamePhase();
    }
}
