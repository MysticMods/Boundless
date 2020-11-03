package com.mart.boundless.registry;

import com.mart.boundless.Boundless;
import com.mart.boundless.block.CosmicInfuserBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Boundless.MOD_ID);

    public static final RegistryObject<Block> cosmic_ore = BLOCKS.register("cosmic_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(3F, 3.0F)));
    public static final RegistryObject<Block> cosmic_infuser = BLOCKS.register("cosmic_infuser", () -> new CosmicInfuserBlock());


    public static void setup() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
