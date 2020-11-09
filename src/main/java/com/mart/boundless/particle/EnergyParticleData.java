package com.mart.boundless.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nullable;
import java.util.Locale;

public class EnergyParticleData implements IParticleData {

    @ObjectHolder("boundless:energy_particle")
    public static ParticleType<EnergyParticleData> TYPE = null;


    public static Codec<EnergyParticleData> codecFor(ParticleType<?> type) {
        return RecordCodecBuilder
                .create((instance) -> instance.group(
                        Codec.FLOAT.fieldOf("r").forGetter(i -> i.r),
                        Codec.FLOAT.fieldOf("g").forGetter(i -> i.g),
                        Codec.FLOAT.fieldOf("b").forGetter(i -> i.b),
                        Codec.FLOAT.fieldOf("a").forGetter(i -> i.a),
                        Codec.FLOAT.fieldOf("targetX").forGetter(i -> i.targetX),
                        Codec.FLOAT.fieldOf("targetY").forGetter(i -> i.targetY),
                        Codec.FLOAT.fieldOf("targetZ").forGetter(i -> i.targetZ),
                        Codec.FLOAT.fieldOf("scale").forGetter(i -> i.scale),
                        Codec.INT.fieldOf("lifetime").forGetter(i -> i.lifetime)
                ).apply(instance, (r, g, b, a, targetX, targetY, targetZ, scale, lifetime) -> {
                    EnergyParticleData data = new EnergyParticleData(type);
                    data.r = r; data.g = g; data.b = b; data.a = a;
                    data.scale = scale;
                    data.lifetime = lifetime;
                    data.targetX = targetX;
                    data.targetY = targetY;
                    data.targetZ = targetZ;
                    return data;
                }));
    }

    public float r = 0, g =0, b =0, a =1.0f;
    public float targetX = 0, targetY =0, targetZ =0;
    public float scale = 0;
    public int lifetime = 20;

    public EnergyParticleData(ParticleType<?> type) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetZ = targetZ;
        this.scale = scale;
        this.lifetime = lifetime;
    }

    @Override
    public ParticleType<?> getType()
    {
        return TYPE;
    }

    @Override
    public void write(PacketBuffer buffer) {
        buffer.writeFloat(r);
        buffer.writeFloat(g);
        buffer.writeFloat(b);
        buffer.writeFloat(a);
        buffer.writeFloat(targetX);
        buffer.writeFloat(targetY);
        buffer.writeFloat(targetZ);
        buffer.writeFloat(scale);
        buffer.writeInt(lifetime);
    }

    @Override
    public String getParameters()
    {
        return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %.2f %d", this.getType().getRegistryName(),
                this.r, this.g, this.b, this.a, this.targetX, this.targetY, this.targetZ, this.scale, this.lifetime);
    }

    public static final IDeserializer<EnergyParticleData> DESERIALIZER = new IDeserializer<EnergyParticleData>()
    {
        @Override
        public EnergyParticleData deserialize(ParticleType<EnergyParticleData> particleTypeIn, StringReader reader) throws CommandSyntaxException
        {
            reader.expect(' ');
            float r = (float)reader.readDouble();
            reader.expect(' ');
            float g = (float)reader.readDouble();
            reader.expect(' ');
            float b = (float)reader.readDouble();
            reader.expect(' ');
            float a = (float)reader.readDouble();
            reader.expect(' ');
            float targetX = (float)reader.readDouble();
            reader.expect(' ');
            float targetY = (float)reader.readDouble();
            reader.expect(' ');
            float targetZ = (float)reader.readDouble();
            reader.expect(' ');
            float scale = (float)reader.readDouble();
            reader.expect(' ');
            int lifetime = (int)reader.readDouble();
            EnergyParticleData data = new EnergyParticleData(particleTypeIn);
            data.r = r; data.g = g; data.b = b; data.a = a;
            data.scale = scale;
            data.lifetime = lifetime;
            data.targetX = targetX;
            data.targetY = targetY;
            data.targetZ = targetZ;
            return data;
        }

        @Override
        public EnergyParticleData read(ParticleType<EnergyParticleData> particleTypeIn, PacketBuffer buffer)
        {
            EnergyParticleData data = new EnergyParticleData(particleTypeIn);
            data.r = buffer.readFloat();
            data.g = buffer.readFloat();
            data.b = buffer.readFloat();
            data.a = buffer.readFloat();
            data.targetX = buffer.readFloat();
            data.targetY = buffer.readFloat();
            data.targetZ = buffer.readFloat();
            data.scale = buffer.readFloat();
            data.lifetime = buffer.readInt();
            return data;
        }
    };


//    public static EnergyParticleData withColor(float red, float green, float blue, float targetX, float targetY, float targetZ, float scale, int lifetime)
//    {
//        return new EnergyParticleData(red,green,blue, 100, targetX,targetY,targetZ, 1, lifetime);
//    }

}
