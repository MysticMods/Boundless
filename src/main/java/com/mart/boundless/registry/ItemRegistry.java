package com.mart.boundless.registry;

import com.mart.boundless.Boundless;
import com.mart.boundless.item.HeatCharmItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Boundless.MOD_ID);

    public static final RegistryObject<Item> cosmic_crystal = ITEMS.register("cosmic_crystal", () -> new Item(new Item.Properties().group(Boundless.ITEM_GROUP)));
    public static final RegistryObject<Item> boundless_attuned_crystal = ITEMS.register("boundless_attuned_crystal", () -> new Item(new Item.Properties().group(Boundless.ITEM_GROUP)));


    public static final RegistryObject<Item> cosmic_charm = ITEMS.register("cosmic_charm", () -> new Item(new Item.Properties().group(Boundless.ITEM_GROUP)));
    public static final RegistryObject<Item> heat_charm = ITEMS.register("heat_charm", () -> new HeatCharmItem());
    //public static final RegistryObject<Item> growth_charm = ITEMS.register("growth_charm", () -> new GrowthCharmItem());


    public static final RegistryObject<Item> COSMIC_ORE = ITEMS.register("cosmic_ore", () -> new BlockItem(BlockRegistry.cosmic_ore.get(), new Item.Properties().group(Boundless.ITEM_GROUP)));
    public static final RegistryObject<Item> cosmic_infuser = ITEMS.register("cosmic_infuser", () -> new BlockItem(BlockRegistry.cosmic_infuser.get(), new Item.Properties().group(Boundless.ITEM_GROUP)));


    public static void setup() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}