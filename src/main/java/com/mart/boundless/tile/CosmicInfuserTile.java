package com.mart.boundless.tile;

import com.mart.boundless.util.BUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class CosmicInfuserTile extends TileEntityBase implements ITickableTileEntity {

    public CosmicInfuserTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ItemStackHandler inventory = new ItemStackHandler(1);

    @Override
    public void tick() {
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.put("inventory", inventory.serializeNBT());
        return compound;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        if(inventory != null){
            inventory.deserializeNBT((CompoundNBT) nbt.get("inventory"));
        }
    }

    public boolean activate(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull PlayerEntity player, @Nonnull Hand hand){
        ItemStack heldItem = player.getHeldItem(hand);

        if(BUtil.addStackToInventory(0, inventory, heldItem, player, hand)){
            if (!world.isRemote) sync();
            return true;
        }

        if (heldItem.isEmpty() && !world.isRemote && hand == Hand.MAIN_HAND) {
            if (!inventory.getStackInSlot(0).isEmpty()) {
                ItemStack extracted = inventory.extractItem(0, inventory.getStackInSlot(0).getCount(), false);
                player.addItemStackToInventory(extracted);
                sync();
                return true;
            }
        }

        return true;
    }

    public ItemStack getItem(){
        return this.inventory.getStackInSlot(0);
    }

}
