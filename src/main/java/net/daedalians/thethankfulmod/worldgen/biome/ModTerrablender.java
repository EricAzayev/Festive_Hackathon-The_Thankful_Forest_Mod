package net.daedalians.thethankfulmod.worldgen.biome;

import net.daedalians.thethankfulmod.TheThankfulMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes(){
        //How often we replace the biome we're replacing (Forest Biome in this example)
        Regions.register(new ModOverworldRegion(new ResourceLocation(TheThankfulMod.MOD_ID,"overworld"),5));
    }
}
