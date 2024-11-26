package net.daedalians.thethankfulmod.datagen.loot;


import net.daedalians.thethankfulmod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;


public class ModBlockLootTables extends BlockLootSubProvider {


    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        //super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override  //If you are here, it is likely due to an error in the ModBlocks class. Either write this.dropSelf() or contact Eric
    protected void generate() { //What does each block drop?
//        this.dropSelf(ModBlocks.FALL_LEAVES.get()); //Leaf blocks will drop themselves.
        this.dropSelf(ModBlocks.FALL_SAPLING.get());
        this.dropSelf(ModBlocks.FALL_GRASS.get());



        this.add(ModBlocks.FALL_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.FALL_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        //this.dropSelf(ModBlocks.MAPLE_LOG.get());



    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
