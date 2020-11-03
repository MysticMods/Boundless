package com.mart.boundless;

import com.mart.boundless.item.BoundlessItemGroup;
import com.mart.boundless.registry.BlockRegistry;
import com.mart.boundless.registry.ItemRegistry;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("boundless")
public class Boundless {

    public static final String MOD_ID = "boundless";
    public static final ItemGroup ITEM_GROUP = new BoundlessItemGroup(MOD_ID, () -> Items.APPLE);

    public static Registrate REGISTRATE;

    public Boundless(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        REGISTRATE = Registrate.create(Boundless.MOD_ID);
        REGISTRATE.itemGroup(NonNullSupplier.of(() -> ITEM_GROUP));

        ItemRegistry.setup();
        BlockRegistry.setup();
    }

    public void setup(final FMLCommonSetupEvent event) {


    }


}
