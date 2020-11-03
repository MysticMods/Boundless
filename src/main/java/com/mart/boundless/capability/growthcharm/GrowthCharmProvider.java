package com.mart.boundless.capability.growthcharm;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class GrowthCharmProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(ICurio.class)
    public static final Capability<ICurio> GROWTH_CHARM_CAPABILITY = nonNullNull();

    private final GrowthCharmCapability myImpl = new GrowthCharmCapability();
    private final LazyOptional<GrowthCharmCapability> lazy = LazyOptional.of(() -> myImpl);



    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == GROWTH_CHARM_CAPABILITY) return lazy.cast();
        return LazyOptional.empty();
    }


    @Override
    public INBT serializeNBT() {
        return myImpl.serializeNBT();
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        myImpl.deserializeNBT(nbt);
    }


    private static final Object NULL = null;

    @SuppressWarnings("unchecked")
    private static <T> T nonNullNull() {
        return (T) NULL;
    }

}
