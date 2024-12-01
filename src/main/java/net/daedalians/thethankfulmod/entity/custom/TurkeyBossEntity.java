package net.daedalians.thethankfulmod.entity.custom;

import net.daedalians.thethankfulmod.ModEntities;
import net.daedalians.thethankfulmod.entity.ai.TurkeyBossAttackGoal;
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
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class TurkeyBossEntity extends Animal{
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(TurkeyBossEntity.class, EntityDataSerializers.BOOLEAN);

    // Animation States
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public TurkeyBossEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    /**
     * General Entity Setup
     */
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING,false);
    }

    @Override
    protected void registerGoals(){
        // Allows entity to float in water
        this.goalSelector.addGoal(0, new FloatGoal(this));
        // Allows entity to move around
        this.goalSelector.addGoal(1, new TurkeyBossAttackGoal(this,1.00F, true));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, (double)0.25F));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        // Specifies what the turkey can attack
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 200.0F)
                .add(Attributes.ATTACK_DAMAGE, 10.0F)
                .add(Attributes.ATTACK_KNOCKBACK, 5.0F);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.PUMPKIN_SEEDS);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.TURKEY_BOSS.get().create(serverLevel);
    }

    /**
     * Custom Animations
     */

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()){
            setupAnimationStates();
        }
    }

    private void setupAnimationStates(){
        if(this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationTimeout = 20; // Length in ticks of animation
            attackAnimationState.start(this.tickCount);
        }else{
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()){
            attackAnimationState.stop();
        }
    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

}
