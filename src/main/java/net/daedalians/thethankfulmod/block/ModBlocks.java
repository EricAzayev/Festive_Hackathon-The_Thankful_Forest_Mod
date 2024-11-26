package net.daedalians.thethankfulmod.block;

import net.daedalians.thethankfulmod.item.ModItems;
import net.daedalians.thethankfulmod.TheThankfulMod;
import net.daedalians.thethankfulmod.worldgen.tree.FallTreeGrower;
import net.daedalians.thethankfulmod.worldgen.ModConfiguredFeatures;
import net.daedalians.thethankfulmod.worldgen.tree.FallTreeGrower;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;
import java.util.function.Supplier;

import static net.daedalians.thethankfulmod.worldgen.ModConfiguredFeatures.FALL_KEY;
//import static net.daedalians.thethankfulmod.worldgen.tree.FallTreeGrower.FallTree.fallTree;
//import static net.daedalians.thethankfulmod.worldgen.tree.FallTreeGrower.fallTree;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, TheThankfulMod.MOD_ID);
    
    public static final RegistryObject<Block> FALL_LEAVES = registerBlock("fall_leaves",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(0.2f)
                    .noOcclusion() // Allows light to pass through
                    .isSuffocating((state, world, pos) -> false) // Prevent suffocation
                    .isViewBlocking((state, world, pos) -> false) // Prevent blocking the view
            ));

    public static final RegistryObject<Block> FALL_SAPLING = registerBlock("fall_sapling",
            () -> new SaplingBlock(new FallTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING))); //return and implement Fall_OAK

    public static final RegistryObject<Block> FALL_GRASS = registerBlock("fall_grass",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

    public static final RegistryObject<Block> SCATTERED_LEAVES = registerBlock("scattered_leaves",
            () -> new FlatBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(0.2f)
                    .noOcclusion() // Allows light to pass through
                    .isSuffocating((state, world, pos) -> false) // Prevent suffocation
                    .isViewBlocking((state, world, pos) -> false) // Prevent blocking the view
                    .noCollission()
                    .noLootTable()
            ));

    //class methods
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


//    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
//            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
//    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
//            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
//
//    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
//        RegistryObject<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name, toReturn);
//        return toReturn;
//    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
