package com.mart.boundless.ritual.requirements;

import com.mart.boundless.event.RegistryEvents;
import com.mart.boundless.particle.Particles;
import com.mart.boundless.ritual.RitualBase;
import com.mart.boundless.tile.CosmicInfuserTile;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;

public class BlockRequirement implements IRequirement {

    private final Block requiredBlock;

    public BlockRequirement(Block block){
        this.requiredBlock = block;
    }

    @Override
    public boolean met(CosmicInfuserTile tile) {
        int rad = 3;
        for(int x = -rad; x< rad+1; x++){
            for(int y = -rad; y< rad+1; y++){
                for(int z = -rad; z< rad+1; z++){
                    if(tile.getWorld().getBlockState(tile.getPos().add(x, y, z)).getBlock() == this.requiredBlock){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
