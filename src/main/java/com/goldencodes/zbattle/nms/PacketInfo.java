package com.goldencodes.zbattle.nms;

import com.goldencodes.zbattle.nms.util.IPacketVerifier;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.entity.Player;

public class PacketInfo {

    private Player _player;
    private Packet _packet;
    private IPacketVerifier _verifier;

    private boolean _cancelled = false;

    public PacketInfo(Player player, Packet packet, IPacketVerifier verifier) {
        _player = player;
        _packet = packet;
        _verifier = verifier;
    }

    public Packet getPacket() { return _packet; }

    public Player getPlayer() { return _player; }

    public IPacketVerifier getVerifier() { return _verifier; }

    public void setCancelled(boolean cancel) { _cancelled = cancel; }

    public boolean isCancelled() { return _cancelled; }
}
