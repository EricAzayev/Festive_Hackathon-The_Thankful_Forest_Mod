package net.daedalians.thethankfulmod.datagen;

import net.daedalians.thethankfulmod.TheThankfulMod;
import net.daedalians.thethankfulmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.Block;
import net.daedalians.thethankfulmod.block.ModBlocks;


public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheThankfulMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() { //hows it held?


        saplingItem(ModBlocks.FALL_SAPLING);
        saplingItem(ModBlocks.MAPLE_SAPLING);
        withExistingParent(ModItems.TURKEY_BOSS_EGG.getId().getPath(), mcLoc("item/turkey_boss_egg"));
        withExistingParent(ModItems.TURKEY_EGG.getId().getPath(), mcLoc("item/turkey_egg"));


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheThankfulMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheThankfulMod.MOD_ID,"block/" + item.getId().getPath()));
    }
}
