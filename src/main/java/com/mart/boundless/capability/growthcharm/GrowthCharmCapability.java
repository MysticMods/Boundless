package com.mart.boundless.capability.growthcharm;

import com.mart.boundless.capability.ICapability;
import com.mart.boundless.event.RegistryEvents;
import com.mart.boundless.particle.Particles;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrowthCharmCapability implements ICurio, ICapability {

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity) {
        if(!livingEntity.getEntityWorld().isRemote){
            ServerWorld world = (ServerWorld) livingEntity.getEntityWorld();
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
                    if(rand.nextInt(80) +1 == 80){
                        CropsBlock crop = (CropsBlock)world.getBlockState(pos).getBlock();
                        crop.randomTick(world.getBlockState(pos), (ServerWorld) livingEntity.getEntityWorld(), pos, rand);

                        if (!world.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
                        if (world.getLightSubtracted(pos, 0) >= 9) {
                            boolean i = crop.canGrow(world, pos, world.getBlockState(pos), false);
                            if (i) {
                                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, world.getBlockState(pos), true)) {
                                    world.setBlockState(pos, crop.withAge(world.getBlockState(pos).get(crop.getAgeProperty()) + 1), 2);
                                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, world.getBlockState(pos));
                                    Particles.create(RegistryEvents.MOVING_PARTICLE).setColor(52,255,36).setAlpha(1).setScale(1).spawn(world, pos.getX(), pos.getY(), pos.getZ());
                                }
                            }
                        }
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
