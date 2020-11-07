package com.mart.boundless.event;

import com.mart.boundless.Boundless;
import com.mart.boundless.particle.EnergyParticleData;
import com.mart.boundless.particle.EnergyParticleType;
import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryEvents {

    public static DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Boundless.MOD_ID);

    public static RegistryObject<EnergyParticleType> ENERGY_PARTICLE = PARTICLES.register("energy_particle", EnergyParticleType::new);

    @SubscribeEvent
    public void registerFactories(ParticleFactoryRegisterEvent evt) {
        Minecraft.getInstance().particles.registerFactory(ENERGY_PARTICLE.get(), EnergyParticleData.Factory::new);
    }

    public static void init(){
        PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
