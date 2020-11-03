package com.mart.boundless;

import com.mart.boundless.item.BoundlessItemGroup;
import com.mart.boundless.registry.BlockRegistry;
import com.mart.boundless.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.fml.common.Mod;

@Mod("boundless")
public class Boundless {

    public static final String MOD_ID = "boundless";
    public static final ItemGroup ITEM_GROUP = new BoundlessItemGroup(MOD_ID, () -> Items.APPLE);
    public Boundless(){
        ItemRegistry.setup();
        BlockRegistry.setup();
    }


}
