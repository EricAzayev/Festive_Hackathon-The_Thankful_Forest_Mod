package net.daedalians.thethankfulmod.worldgen;

import net.daedalians.thethankfulmod.TheThankfulMod;
import net.daedalians.thethankfulmod.block.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;

public class ModConfiguredFeatures {
    //feature you can configure with certain variables

    //public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FALL_KEY = registerKey("fall"); //fall tree (cleared)
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        register(context, FALL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder( //build tree
                //choose branch content
                BlockStateProvider.simple(Blocks.OAK_LOG), //stateprovide: what block should be placed?
                new StraightTrunkPlacer(3, 4, 3),
                //baseHeight, heightRandomA, highRandomB
                //choose leaf content
                BlockStateProvider.simple(ModBlocks.FALL_LEAVES.get()), //stateprovide: what block should be placed?
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                                                            // radius,offset,foliageHeight
                new TwoLayersFeatureSize(1, 0, 2)).build()); //check for how much space?


        register(context, MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder( //build tree
                //choose branch content
                BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()), //stateprovide: what block should be placed?
                //new StraightTrunkPlacer(3, 4, 3),
                new CherryTrunkPlacer(3, 2, 3, //baseHeight, heightRandA, heightRandB
                        ConstantInt.of(2),ConstantInt.of(3), //branchCount, branchHorizontalLength
                        UniformInt.of(-3,0),ConstantInt.of(1)), //branchStartOffsetFromTop, //EndOffsetFromTop

                BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), //stateprovide: what block should be placed?
                //new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1),ConstantInt.of(4),0.2f,0.12f,0.25f,0.12f),
                // radius,offset,foliageHeight,
                new TwoLayersFeatureSize(0, 0, 0)).build()); //check for how much space?
    }

//      this.branchCount = p_272873_;
//      this.branchHorizontalLength = p_272789_;
//      this.branchStartOffsetFromTop = p_272917_;
//      this.secondBranchStartOffsetFromTop = UniformInt.of(p_272917_.getMinValue(), p_272917_.getMaxValue() - 1);
//      this.branchEndOffsetFromTop = p_272948_;


//        register(context, PINE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                BlockStateProvider.simple(ModBlocks.PINE_LOG.get()),
//                new StraightTrunkPlacer(5, 4, 3),
//
//                BlockStateProvider.simple(ModBlocks.PINE_LEAVES.get()),
//                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
//
//                new TwoLayersFeatureSize(1, 0, 2)).build());
//    }



    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TheThankfulMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, Feature<TreeConfiguration> feature, TreeConfiguration configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
