package com.mart.boundless.network;

import com.mart.boundless.Boundless;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Networking {
    public static SimpleChannel INSTANCE;

    static int id = 0;

    public static void init() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(Boundless.MOD_ID, "network"), () -> "1.0", (s) -> true, (s) -> true);


        INSTANCE.registerMessage(
                ++ id,
                TESyncPacket.class,
                TESyncPacket::encode,
                TESyncPacket::decode,
                TESyncPacket::consume
        );
    }

    public static <MSG> void sendToDimension(World world, MSG msg, RegistryKey<World> dimension) {
        Networking.INSTANCE.send(PacketDistributor.DIMENSION.with(() -> dimension), msg);
    }

    public static <MSG> void sendToTracking(World world, BlockPos pos, MSG msg) {
        Networking.INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(() -> world.getChunkAt(pos)), msg);
    }
}
