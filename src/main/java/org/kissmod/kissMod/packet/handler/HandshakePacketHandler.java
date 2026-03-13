package org.kissmod.kissMod.packet.handler;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.kissmod.kissMod.KissModPlugin;
import org.kissmod.kissMod.packet.KissPacketManager;

public class HandshakePacketHandler implements PacketHandler {

    @Override
    public void handle(Player sender, ByteArrayDataInput buf) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        if (sender.isOnline()) {
            sender.sendPluginMessage(KissModPlugin.getInstance(),KissPacketManager.HANDSHAKE_S2C_PACKET_ID, out.toByteArray());
        }
    }

    @Override
    public String getPacketID() {
        return KissPacketManager.HANDSHAKE_C2S_PACKET_ID;
    }
}
