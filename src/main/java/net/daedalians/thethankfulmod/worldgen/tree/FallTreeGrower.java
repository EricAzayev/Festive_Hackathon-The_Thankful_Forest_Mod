package net.daedalians.thethankfulmod.worldgen.tree;

import net.daedalians.thethankfulmod.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class FallTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeatures.FALL_KEY;
    }
}



    //private final TreeGrower treeGrower = new TreeGrower();
//    @Nullable
//    //@Override
//    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
//        return ModConfiguredFeatures.FALL_KEY;
//    }


//    public TreeGrower(
//            String pName,
//            Optional<ResourceKey<ConfiguredFeature<?, ?>>> pMegaTree,
//            Optional<ResourceKey<ConfiguredFeature<?, ?>>> pTree,
//            Optional<ResourceKey<ConfiguredFeature<?, ?>>> pFlowers
//    ) {
//        this(pName, 0.0F, pMegaTree, Optional.empty(), pTree, Optional.empty(), pFlowers, Optional.empty());
//    }
