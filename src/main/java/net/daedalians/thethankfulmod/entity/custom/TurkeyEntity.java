package net.daedalians.thethankfulmod.entity.custom;

import net.daedalians.thethankfulmod.ModEntities;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class TurkeyEntity extends Animal {
    public TurkeyEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    /**
     * General Entity Setup
     */
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
    }

    @Override
    protected void registerGoals(){
        // Allows entity to float in water
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, (double)1.0F));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, Ingredient.of(Items.PUMPKIN_SEEDS), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1));
        // Allows entity to move around
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, (double)1.0F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        // Specifies what the turkey can attack
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, (double)4.0F).add(Attributes.MOVEMENT_SPEED, (double)0.25F);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.PUMPKIN_SEEDS);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.TURKEY.get().create(serverLevel);
    }


    /**
     * To Be Added: Custom Animations
     */
}
