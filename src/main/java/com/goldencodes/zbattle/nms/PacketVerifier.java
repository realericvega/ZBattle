package com.goldencodes.zbattle.nms;

import com.goldencodes.zbattle.nms.util.IPacketVerifier;
import org.bukkit.entity.Player;

public class PacketVerifier implements IPacketVerifier {

    private Player _owner;
    private PacketHandler _packetHandler;
}
