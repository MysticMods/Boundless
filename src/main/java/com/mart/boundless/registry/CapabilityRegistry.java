package com.mart.boundless.registry;

import com.mart.boundless.Boundless;
import com.mart.boundless.capability.growthcharm.GrowthCharmProvider;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosCapability;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = Boundless.MOD_ID)
public class CapabilityRegistry {
    @SubscribeEvent
    public static void addCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
        if(event.getObject().getItem() == ItemRegistry.growth_charm.get()) {
            event.addCapability(CuriosCapability.ID_ITEM, new GrowthCharmProvider());
        }

    }
}
