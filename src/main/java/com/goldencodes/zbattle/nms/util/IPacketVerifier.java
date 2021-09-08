package com.goldencodes.zbattle.nms.util;

import net.minecraft.server.v1_8_R3.Packet;

public interface IPacketVerifier {

    boolean handlePacket(Packet var1);
}
