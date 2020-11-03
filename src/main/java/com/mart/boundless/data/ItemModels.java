package com.mart.boundless.data;

import com.mart.boundless.Boundless;
import com.mart.boundless.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ItemModels extends ItemModelProvider {

    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Boundless.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()) {
            String name = item.get().getRegistryName().getPath();
            singleTexture(name, mcLoc("item/handheld"), "layer0", modLoc("item/" + name));
        }

    }
}