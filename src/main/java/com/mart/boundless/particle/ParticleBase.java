package com.mart.boundless.particle;

import com.mart.boundless.config.ClientConfig;
import com.mart.boundless.event.ClientEvents;
import com.mart.boundless.util.RenderUtil;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class ParticleBase extends SpriteTexturedParticle {

    public float scale;
    public float targetX;
    public float targetY;
    public float targetZ;
    public float a;
    public float xpos, ypos, zpos;

    protected ParticleBase(EnergyParticleData data, ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);

        this.setPosition(x, y, z);
        this.setMaxAge(data.lifetime);

        this.setColor(data.r/255, data.g/255, data.b/255);

        this.particleGravity = 0;

        this.scale = data.scale / 100;
        this.a = data.a;

//        this.targetX = data.targetX;
//        this.targetY = data.targetY;
//        this.targetZ = data.targetZ;
//        this.xpos = (float) x;
//        this.ypos = (float) y;
//        this.zpos = (float) z;

//        float dx = (float) (targetX - x);
//        float dy = (float) (targetY - y);
//        float dz = (float) (targetZ - z);
//        float d = MathHelper.sqrt(dx*dx + dy*dy + dz*dz);
//
//        this.motionX = dx/d * 0.2;
//        this.motionY = dy/d * 0.2;
//        this.motionZ = dz/d * 0.2;

        this.canCollide = false;
    }

    @Override
    public IParticleRenderType getRenderType() {
        return SpriteParticleRenderType.INSTANCE;
    }

    @Override
    public void tick() {
//        this.prevPosX = this.posX;
//        this.prevPosY = this.posY;
//        this.prevPosZ = this.posZ;
//        if (this.age++ >= this.maxAge) {
//            this.setExpired();
//        }
            super.tick();
        this.motionX *= (double)0.90F;
        this.motionY *= (double)0.90F;
        this.motionZ *= (double)0.90F;
//        float dx = targetX - xpos;
//        float dy = targetY - ypos;
//        float dz = targetZ - zpos;
//        float distance = MathHelper.sqrt(dx*dx + dy*dy + dz*dz);
//        if (distance > -0.2 && distance < 0.2) {
//            this.setExpired();
//        }
//
//
//        if (distance > -0.2 && distance < 0.2) {
//            this.setExpired();
//        }
//
//        this.move(this.motionX / 4, this.motionY / 4, this.motionZ / 4);
//        this.xpos += this.motionX / 4;
//        this.ypos += this.motionY / 4;
//        this.zpos += this.motionZ / 4;
    }

//    @Override
//    public void renderParticle(IVertexBuilder b, ActiveRenderInfo info, float pticks) {
//        super.renderParticle(ClientConfig.BETTER_LAYERING.get() ? ClientEvents.getDelayedRender().getBuffer(RenderUtil.GLOWING_PARTICLE) : b, info, pticks);
//    }
}
