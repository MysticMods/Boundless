package com.mart.boundless.registry;

import com.mart.boundless.item.GrowthCharmItem;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.item.Item;

import static com.mart.boundless.Boundless.REGISTRATE;

public class ItemRegistry {

    public static final RegistryEntry<Item> cosmic_crystal = REGISTRATE.item("cosmic_crystal", Item::new)
            .register();
    public static final RegistryEntry<Item> cosmic_charm = REGISTRATE.item("cosmic_charm", Item::new)
            .register();
    public static final RegistryEntry<Item> heat_charm = REGISTRATE.item("heat_charm", Item::new)
            .register();
    public static final RegistryEntry<GrowthCharmItem> growth_charm = REGISTRATE.item("growth_charm", GrowthCharmItem::new)
            .register();


    //public static final RegistryEntry<Item> COSMIC_ORE = ITEMS.register("cosmic_ore", () -> new BlockItem(BlockRegistry.cosmic_ore.get(), new Item.Properties().group(Boundless.ITEM_GROUP)));
    //public static final RegistryEntry<Item> cosmic_infuser = ITEMS.register("cosmic_infuser", () -> new BlockItem(BlockRegistry.cosmic_infuser.get(), new Item.Properties().group(Boundless.ITEM_GROUP)));


    public static void setup() {

    }
}