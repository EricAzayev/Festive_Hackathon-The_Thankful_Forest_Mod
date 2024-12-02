package net.daedalians.thethankfulmod.item;

import net.daedalians.thethankfulmod.ModEntities;
import net.daedalians.thethankfulmod.TheThankfulMod;
import net.daedalians.thethankfulmod.entity.custom.TurkeyBossEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheThankfulMod.MOD_ID);


//    public static final RegistryObject<Item> FALL_SAPLING = ITEMS.register("fall_sapling",
//            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TURKEY_BOSS_EGG = ITEMS.register("turkey_boss_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TURKEY_BOSS,0xFFFFFF, 0xFFFFFF, new Item.Properties()));
    public static final RegistryObject<Item> TURKEY_EGG = ITEMS.register("turkey_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TURKEY,0xFFFFFF, 0xFFFFFF, new Item.Properties()));

//    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
//            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
