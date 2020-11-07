package com.mart.boundless.particle;

import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;

public class ParticleBase extends SpriteTexturedParticle {


    protected ParticleBase(EnergyParticleData data, ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, 0, 0, 0);
        this.setPosition(x, y, z);
        this.setMaxAge(20);
        this.particleGravity = 0;
    }

    @Override
    public IParticleRenderType getRenderType() {
        return SpriteParticleRenderType.INSTANCE;
    }

    @Override
    public void tick() {
        super.tick();
    }

}
