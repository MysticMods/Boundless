package com.mart.boundless.block;

import com.mart.boundless.registry.ModTiles;
import com.mart.boundless.tile.CosmicInfuserTile;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class CosmicInfuserBlock extends Block {

    private VoxelShape  bounds = Block.makeCuboidShape(0, 0, 0, 16, 13, 16);

    public CosmicInfuserBlock(Properties properties) {
        super(properties.notSolid());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return bounds;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTiles.cosmic_infuser.create();
    }
}
