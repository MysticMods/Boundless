package com.mart.boundless.capability.growthcharm;

import com.mart.boundless.capability.ICapability;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrowthCharmCapability implements ICurio, ICapability {

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity) {
        World world = livingEntity.getEntityWorld();
        if(!world.isRemote){
            if(world.getGameTime() % 20 == 0){
                Random rand = new Random();
                List<BlockPos> plantBlocks = new ArrayList<>();
                BlockPos position = livingEntity.getPosition();
                int rad = 10;
                for(int x = -rad; x< rad+1; x++){
                    for(int y = -rad; y< rad+1; y++){
                        for(int z = -rad; z< rad+1; z++){
                            if(world.getBlockState(position.add(x, y, z)).getBlock() instanceof CropsBlock){
                                plantBlocks.add(position.add(x, y, z));
                            }
                        }
                    }
                }

                for (BlockPos pos: plantBlocks ) {
                    if(rand.nextInt(10) +1 == 10){
                        CropsBlock crop = (CropsBlock)world.getBlockState(pos).getBlock();
                        crop.randomTick(world.getBlockState(pos), (ServerWorld) livingEntity.getEntityWorld(), pos, rand);
                    }
                }
            }
        }
    }


    @Override
    public INBT serializeNBT() {
        return new ListNBT();
    }

    @Override
    public void deserializeNBT(INBT tag) {

    }
}
