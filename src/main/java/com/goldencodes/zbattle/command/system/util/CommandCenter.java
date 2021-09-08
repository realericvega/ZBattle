package com.goldencodes.zbattle.command.system.util;

import com.goldencodes.zbattle.nms.util.IPacketHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandCenter implements Listener, IPacketHandler {

    public static final List<String> ALLOW_SPAM_IF_LAST = new ArrayList<>();
    public static CommandCenter instance;

    protected JavaPlugin Plugin;
    protected HashMap<String, ICommand> Commands;
}
