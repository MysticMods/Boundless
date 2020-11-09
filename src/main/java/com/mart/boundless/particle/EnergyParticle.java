package com.mart.boundless.particle;

import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;

public class EnergyParticle extends SpriteTexturedParticle {



    protected EnergyParticle(EnergyParticleData data, ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);

        this.setPosition(x, y, z);
        this.setMaxAge(data.lifetime);

        this.setColor(data.r/255, data.g/255, data.b/255);

        this.particleGravity = 0;

        this.canCollide = false;
    }

    @Override
    public IParticleRenderType getRenderType() {
        return SpriteParticleRenderType.INSTANCE;
    }

    @Override
    public void tick() {
        super.tick();
    }

//    @Override
//    public void renderParticle(IVertexBuilder b, ActiveRenderInfo info, float pticks) {
//        super.renderParticle(ClientConfig.BETTER_LAYERING.get() ? ClientEvents.getDelayedRender().getBuffer(RenderUtil.GLOWING_PARTICLE) : b, info, pticks);
//    }
}
