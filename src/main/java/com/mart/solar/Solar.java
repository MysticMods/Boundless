package com.mart.solar;

import com.mart.solar.common.item.SolarItemGroup;
import com.mart.solar.common.registry.BlockRegistry;
import com.mart.solar.common.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("solar")
public class Solar {

    public static final String MOD_ID = "solar";
    public static final ItemGroup ITEM_GROUP = new SolarItemGroup(MOD_ID, () -> Items.APPLE);
    public Solar(){
        ItemRegistry.setup();
        BlockRegistry.setup();
    }


}
