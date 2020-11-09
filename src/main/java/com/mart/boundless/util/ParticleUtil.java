package com.mart.boundless.util;

import com.mart.boundless.particle.EnergyParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class ParticleUtil {

    public static void spawnServerGrowthCharmParticle(ServerWorld world, BlockPos pos){
        world.spawnParticle(EnergyParticleData.withColor(52, 255, 36, 0,0, 0, 1, 30),
                pos.getX(), pos.getY() + 1, pos.getZ(), 3,0,0, 0, 0.1);
    }

}
