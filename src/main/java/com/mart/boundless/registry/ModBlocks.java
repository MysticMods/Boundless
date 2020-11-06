package com.mart.boundless.registry;

import com.mart.boundless.Boundless;
import com.mart.boundless.block.CosmicInfuserBlock;
import com.mart.boundless.tile.CosmicInfuserTile;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.mart.boundless.Boundless.REGISTRATE;

public class ModBlocks {

    public static <T extends Block> void simpleBlockState(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider p) {
        p.simpleBlock(ctx.getEntry());
    }

    public static <T extends Block> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> simpleBlockState(ResourceLocation parent) {
        return (ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(parent));
    }

    public static <T extends Block> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> simpleBlockState(String parent) {
        return simpleBlockState(new ResourceLocation(Boundless.MOD_ID, parent));
    }

    public static final RegistryEntry<Block> cosmic_ore = REGISTRATE.block("cosmic_ore", Material.ROCK, Block::new)
            .properties(p -> p.setRequiresTool().hardnessAndResistance(3F, 3.0F))
            .item()
            .model((ctx, p) -> p.blockItem(ModBlocks.cosmic_ore))
            .build()
            .blockstate(ModBlocks::simpleBlockState)
            .register();

    public static RegistryEntry<CosmicInfuserBlock> cosmic_infuser = REGISTRATE.block("cosmic_infuser", Material.ROCK, CosmicInfuserBlock::new)
            .properties(p -> p.setRequiresTool().hardnessAndResistance(3F, 3.0F))
            .item()
            .build()
            .blockstate(ModBlocks::simpleBlockState)
            .tileEntity(CosmicInfuserTile::new).build()
            .register();



    public static void setup() {
    }
}
