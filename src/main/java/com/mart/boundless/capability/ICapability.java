package com.mart.boundless.capability;

import net.minecraft.nbt.INBT;

public interface ICapability {
    INBT serializeNBT();
    void deserializeNBT(INBT tag);
}