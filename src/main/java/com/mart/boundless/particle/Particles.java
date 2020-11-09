package com.mart.boundless.particle;

import net.minecraft.particles.ParticleType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.RegistryObject;

import java.util.Random;

public class Particles {
    public static class ParticleBuilder {
        static Random random = new Random();

        ParticleType<?> type;
        EnergyParticleData data;
        double vx = 0, vy = 0, vz = 0;
        double dx = 0, dy = 0, dz = 0;
        double maxXSpeed = 0, maxYSpeed = 0, maxZSpeed = 0;
        double maxXDist = 0, maxYDist = 0, maxZDist = 0;

        protected ParticleBuilder(ParticleType<?> type) {
            this.type = type;
            this.data = new EnergyParticleData(type);
        }

        public ParticleBuilder setColor(float r, float g, float b) {
            setColor(r, g, b, data.a);
            return this;
        }

        public ParticleBuilder setColor(float r, float g, float b, float a) {
            data.r = r; data.g = g; data.b = b; data.a = a;
            return this;
        }


        public ParticleBuilder setAlpha(float a) {
            data.a = a;
            return this;
        }


        public ParticleBuilder setScale(float scale) {
            data.scale = scale;
            return this;
        }


        public ParticleBuilder setLifetime(int lifetime) {
            data.lifetime = lifetime;
            return this;
        }

        public ParticleBuilder randomVelocity(double maxSpeed) {
            randomVelocity(maxSpeed, maxSpeed, maxSpeed);
            return this;
        }

        public ParticleBuilder randomVelocity(double maxHSpeed, double maxVSpeed) {
            randomVelocity(maxHSpeed, maxVSpeed, maxHSpeed);
            return this;
        }

        public ParticleBuilder randomVelocity(double maxXSpeed, double maxYSpeed, double maxZSpeed) {
            this.maxXSpeed = maxXSpeed;
            this.maxYSpeed = maxYSpeed;
            this.maxZSpeed = maxZSpeed;
            return this;
        }

        public ParticleBuilder addVelocity(double vx, double vy, double vz) {
            this.vx += vx;
            this.vy += vy;
            this.vz += vz;
            return this;
        }

        public ParticleBuilder setVelocity(double vx, double vy, double vz) {
            this.vx = vx;
            this.vy = vy;
            this.vz = vz;
            return this;
        }

        public ParticleBuilder randomOffset(double maxDistance) {
            randomOffset(maxDistance, maxDistance, maxDistance);
            return this;
        }

        public ParticleBuilder randomOffset(double maxHDist, double maxVDist) {
            randomOffset(maxHDist, maxVDist, maxHDist);
            return this;
        }

        public ParticleBuilder randomOffset(double maxXDist, double maxYDist, double maxZDist) {
            this.maxXDist = maxXDist;
            this.maxYDist = maxYDist;
            this.maxZDist = maxZDist;
            return this;
        }

        public ParticleBuilder spawn(World world, double x, double y, double z) {
            double yaw = random.nextFloat() * Math.PI * 2, pitch = random.nextFloat() * Math.PI - Math.PI / 2,
                    xSpeed = random.nextFloat() * maxXSpeed, ySpeed = random.nextFloat() * maxYSpeed, zSpeed = random.nextFloat() * maxZSpeed;
            this.vx += Math.sin(yaw) * Math.cos(pitch) * xSpeed;
            this.vy += Math.sin(pitch) * ySpeed;
            this.vz += Math.cos(yaw) * Math.cos(pitch) * zSpeed;
            double yaw2 = random.nextFloat() * Math.PI * 2, pitch2 = random.nextFloat() * Math.PI - Math.PI / 2,
                    xDist = random.nextFloat() * maxXDist, yDist = random.nextFloat() * maxYDist, zDist = random.nextFloat() * maxZDist;
            this.dx = Math.sin(yaw2) * Math.cos(pitch2) * xDist;
            this.dy = Math.sin(pitch2) * yDist;
            this.dz = Math.cos(yaw2) * Math.cos(pitch2) * zDist;

            if(world instanceof ServerWorld){
                ((ServerWorld) world).spawnParticle(data, x + dx, y + dy, z + dz, 1, vx, vy, vz, 1);
            } else {
                world.addParticle(data, x + dx, y + dy, z + dz, vx, vy, vz);
            }
            return this;
        }

        public ParticleBuilder repeat(World world, double x, double y, double z, int n) {
            for (int i = 0; i < n; i ++) spawn(world, x, y, z);
            return this;
        }
    }

    public static ParticleBuilder create(ParticleType<?> type) {
        return new ParticleBuilder(type);
    }

    public static ParticleBuilder create(RegistryObject<?> type) {
        return new ParticleBuilder((ParticleType<?>)type.get());
    }
}