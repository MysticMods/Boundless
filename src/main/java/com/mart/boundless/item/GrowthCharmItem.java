package com.mart.boundless.item;

import com.mart.boundless.Boundless;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.List;

public class GrowthCharmItem extends Item implements ICurio {

    public GrowthCharmItem() {
        super(new Properties().group(Boundless.ITEM_GROUP).maxStackSize(1));
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity) {
        List<LivingEntity> entityList = livingEntity.getEntityWorld().getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
                livingEntity.getPosX() -3, livingEntity.getPosY() -3,livingEntity.getPosZ() -3,
                livingEntity.getPosX() + 3, livingEntity.getPosY() + 3,livingEntity.getPosZ() +  3));
        for(LivingEntity entity : entityList){
            entity.setFire(10);
        }
    }
}
