package com.mart.boundless.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class BoundlessItemGroup extends ItemGroup {
    private final Supplier<IItemProvider> iconItem;

    public BoundlessItemGroup(String name, Supplier<IItemProvider> iconItem) {
        super(name);
        this.iconItem = iconItem;
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(this.iconItem.get());
    }
}