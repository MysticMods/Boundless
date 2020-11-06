package com.mart.boundless.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraftforge.items.ItemStackHandler;

public class BUtil {

    public static boolean addStackToInventory(int slot, ItemStackHandler inventory, ItemStack heldItem, PlayerEntity player, Hand hand){
        if (inventory.getStackInSlot(slot).isEmpty()) {
            ItemStack insertStack = heldItem.copy();
            insertStack.setCount(1);
            ItemStack attemptedInsert = inventory.insertItem(slot, insertStack, true);
            if (attemptedInsert.isEmpty()) {
                inventory.insertItem(slot, insertStack, false);
                player.getHeldItem(hand).shrink(1);
                if (player.getHeldItem(hand).getCount() == 0) {
                    player.setHeldItem(hand, ItemStack.EMPTY);
                }
                return true;
            }
        }
        return false;
    }

}
