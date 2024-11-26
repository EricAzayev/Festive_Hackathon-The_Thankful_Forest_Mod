package net.daedalians.thethankfulmod;

import net.daedalians.thethankfulmod.entity.custom.TurkeyEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheThankfulMod.MOD_ID);

    public static final RegistryObject<EntityType<TurkeyEntity>> TURKEY =
            ENTITY_TYPES.register("turkey", () -> EntityType.Builder.of(TurkeyEntity::new, MobCategory.CREATURE)
                    // Sets the shadow of the mob
                    .sized(.5f, .5f).build("turkey"));


    public static void register(IEventBus eventbus){
        ENTITY_TYPES.register(eventbus);
    }


}
