package com.mart.boundless.event;

import com.mart.boundless.Boundless;
import com.mart.boundless.particle.EnergyMovingParticleType;
import com.mart.boundless.particle.EnergyParticleData;
import com.mart.boundless.particle.ParticleBaseType;
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

    public static RegistryObject<ParticleBaseType> ENERGY_PARTICLE = PARTICLES.register("energy_particle", ParticleBaseType::new);
    public static RegistryObject<EnergyMovingParticleType> MOVING_PARTICLE = PARTICLES.register("energy_moving_particle", EnergyMovingParticleType::new);

    @SubscribeEvent
    public void registerFactories(ParticleFactoryRegisterEvent evt) {
        Minecraft.getInstance().particles.registerFactory(ENERGY_PARTICLE.get(), ParticleBaseType.Factory::new);
        Minecraft.getInstance().particles.registerFactory(MOVING_PARTICLE.get(), EnergyMovingParticleType.MovingFactory::new);
    }

    public static void init(){
        PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
