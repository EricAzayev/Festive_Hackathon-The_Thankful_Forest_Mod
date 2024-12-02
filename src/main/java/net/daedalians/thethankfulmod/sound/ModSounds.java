package net.daedalians.thethankfulmod.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = "the_thankful_mod", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSounds {

    // Deferred Register for sound events
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "the_thankful_mod");

    // Registering your custom sound
    public static final RegistryObject<SoundEvent> TURKEY_GOBBLE =
            SOUND_EVENTS.register("gobble",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_thankful_mod", "gobble")));

    public static final RegistryObject<SoundEvent> TURKEY_HURT =
            SOUND_EVENTS.register("hurt",
                    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_thankful_mod", "hurt")));

    // Method to register sound events to the event bus
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
