package net.daedalians.thethankfulmod.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;


public class GrassBlock extends Block{

    public GrassBlock(Properties pProperties) {
        super(pProperties);
    }

    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable){
        return true;
    }
}
