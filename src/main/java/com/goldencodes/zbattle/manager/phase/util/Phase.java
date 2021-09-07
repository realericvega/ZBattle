package com.goldencodes.zbattle.manager.phase.util;

import org.bukkit.event.Listener;

public abstract class Phase implements Listener {

    public abstract void onEnable();

    public abstract void onDisable();

    public abstract Phase getNextPhase();
}
