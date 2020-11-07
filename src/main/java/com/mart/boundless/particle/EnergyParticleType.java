package com.mart.boundless.particle;

import com.mojang.serialization.Codec;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;

public class EnergyParticleType extends ParticleType<EnergyParticleData> {


    public EnergyParticleType() {
        super(false, EnergyParticleData.DESERIALIZER);
    }

    @Override
    public Codec<EnergyParticleData> func_230522_e_() {
        return EnergyParticleData.CODEC;
    }
}
