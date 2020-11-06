package com.mart.boundless.proxy;

import com.mart.boundless.registry.ModTiles;
import com.mart.boundless.render.CosmicInfuserRender;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy implements ISidedProxy {
    @Override
    public void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientProxy::clientSetup);
    }

    @Override
    public World getWorld() {
        return Minecraft.getInstance().world;
    }

    @OnlyIn(Dist.CLIENT)
    public static void clientSetup(final FMLClientSetupEvent event){
        ClientRegistry.bindTileEntityRenderer(ModTiles.cosmic_infuser.get(), CosmicInfuserRender::new);
    }
}
