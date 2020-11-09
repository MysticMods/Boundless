package com.mart.boundless.particle;

import com.mojang.serialization.Codec;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;

import javax.annotation.Nullable;

public class ParticleBaseType extends ParticleType<EnergyParticleData> {


    public ParticleBaseType() {
        super(false, EnergyParticleData.DESERIALIZER);
    }

    @Override
    public Codec<EnergyParticleData> func_230522_e_() {
        return EnergyParticleData.codecFor(this);
    }

    public static class Factory implements IParticleFactory<EnergyParticleData>
    {

        private final IAnimatedSprite sprite;

        public Factory(IAnimatedSprite sprite) {
            this.sprite = sprite;
        }

        @Nullable
        @Override
        public Particle makeParticle(EnergyParticleData colorData, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed)
        {
            EnergyParticle base = new EnergyParticle(colorData, worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            base.selectSpriteWithAge(sprite);
            return base;
        }
    }

}
