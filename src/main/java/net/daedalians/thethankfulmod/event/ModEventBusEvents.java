package net.daedalians.thethankfulmod.event;

import net.daedalians.thethankfulmod.ModEntities;
import net.daedalians.thethankfulmod.TheThankfulMod;
import net.daedalians.thethankfulmod.entity.custom.TurkeyEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= TheThankfulMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.TURKEY.get(), TurkeyEntity.createAttributes().build());
    }
}
