package com.mart.solar.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class CosmicInfuserBlock extends Block {

    public CosmicInfuserBlock() {
        super(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(3F, 3.0F));
    }
}
