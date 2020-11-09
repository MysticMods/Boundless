package com.mart.boundless.ritual;

import com.mart.boundless.ritual.requirements.BlockRequirement;
import net.minecraft.block.Blocks;

public class GrowthCharmRitual extends RitualBase{


    public GrowthCharmRitual() {
        super("growth_charm_ritual");
        addRequirement(new BlockRequirement(Blocks.LAVA));
    }


}
