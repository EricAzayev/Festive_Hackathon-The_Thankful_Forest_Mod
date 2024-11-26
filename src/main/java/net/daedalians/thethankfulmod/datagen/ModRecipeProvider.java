package net.daedalians.thethankfulmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
//import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }


//    @Override
//    protected void buildRecipes(RecipeOutput pRecipeOutput) {
//
//    }


//    private static void smeltingResultFromBase(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
//        SimpleCookingRecipeBuilder.smelting(Ingredient.of(pIngredient), RecipeCategory.BUILDING_BLOCKS, pResult, 0.1F, 200)
//                .unlockedBy(getHasName(pIngredient), has(pIngredient))
//                .save(pRecipeOutput);
//    }
}
