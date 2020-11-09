package com.mart.boundless;

import com.mart.boundless.config.ClientConfig;
import com.mart.boundless.event.ClientEvents;
import com.mart.boundless.event.RegistryEvents;
import com.mart.boundless.item.BoundlessItemGroup;
import com.mart.boundless.network.Networking;
import com.mart.boundless.proxy.ClientProxy;
import com.mart.boundless.proxy.ISidedProxy;
import com.mart.boundless.proxy.ServerProxy;
import com.mart.boundless.registry.ModBlocks;
import com.mart.boundless.registry.ModItems;
import com.mart.boundless.registry.ModTiles;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("boundless")
public class Boundless {

    public static final String MOD_ID = "boundless";
    public static final ItemGroup ITEM_GROUP = new BoundlessItemGroup(MOD_ID, () -> Items.APPLE);

    public static Registrate REGISTRATE;

    public static ISidedProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);


    public Boundless(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().register(new RegistryEvents());
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);

        RegistryEvents.init();

        proxy.init();

        REGISTRATE = Registrate.create(Boundless.MOD_ID);
        REGISTRATE.itemGroup(NonNullSupplier.of(() -> ITEM_GROUP));

        ModItems.setup();
        ModBlocks.setup();
        ModTiles.setup();

        MinecraftForge.EVENT_BUS.register(new ClientEvents());
    }

    public void setup(final FMLCommonSetupEvent event) {
        Networking.init();

    }


}
