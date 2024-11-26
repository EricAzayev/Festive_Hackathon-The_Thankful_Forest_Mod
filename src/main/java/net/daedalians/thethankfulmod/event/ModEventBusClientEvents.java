package net.daedalians.thethankfulmod.event;

import net.daedalians.thethankfulmod.TheThankfulMod;
import net.daedalians.thethankfulmod.entity.client.ModModelLayers;
import net.daedalians.thethankfulmod.entity.client.TurkeyModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= TheThankfulMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.TURKEY_LAYER, TurkeyModel::createBodyLayer);
    }
}
