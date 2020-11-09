package com.mart.boundless.particle;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;

public class EnergyMovingParticle extends EnergyParticle {

    public float scale;
    public float targetX;
    public float targetY;
    public float targetZ;
    public float a;
    public float xpos, ypos, zpos;

    protected EnergyMovingParticle(EnergyParticleData data, ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(data, world, x, y, z, motionX, motionY, motionZ);

        this.targetX = data.targetX;
        this.targetY = data.targetY;
        this.targetZ = data.targetZ;
        this.xpos = (float) x;
        this.ypos = (float) y;
        this.zpos = (float) z;

        float dx = (float) (targetX - x);
        float dy = (float) (targetY - y);
        float dz = (float) (targetZ - z);
        float d = MathHelper.sqrt(dx*dx + dy*dy + dz*dz);

        this.motionX = dx/d * 0.2;
        this.motionY = dy/d * 0.2;
        this.motionZ = dz/d * 0.2;
    }

    @Override
    public void tick() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.age++ >= this.maxAge) {
            this.setExpired();
        }

        float dx = targetX - xpos;
        float dy = targetY - ypos;
        float dz = targetZ - zpos;
        float distance = MathHelper.sqrt(dx*dx + dy*dy + dz*dz);
        if (distance > -0.2 && distance < 0.2) {
            this.setExpired();
        }


        if (distance > -0.2 && distance < 0.2) {
            this.setExpired();
        }

        this.move(this.motionX / 4, this.motionY / 4, this.motionZ / 4);
        this.xpos += this.motionX / 4;
        this.ypos += this.motionY / 4;
        this.zpos += this.motionZ / 4;
    }
}
