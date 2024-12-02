package net.daedalians.thethankfulmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.daedalians.thethankfulmod.TheThankfulMod;
import net.daedalians.thethankfulmod.entity.custom.TurkeyBossEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TurkeyBossRenderer extends MobRenderer<TurkeyBossEntity, TurkeyBossModel<TurkeyBossEntity>> {
    public TurkeyBossRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TurkeyBossModel<>(pContext.bakeLayer(ModModelLayers.TURKEY_BOSS_LAYER)), .5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TurkeyBossEntity turkeyBossEntity) {
        return new ResourceLocation(TheThankfulMod.MOD_ID, "textures/entity/turkey_boss.png");
    }

    @Override
    public void render(TurkeyBossEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight){
        // Changes the size of the entity
        pMatrixStack.scale(5f, 5f, 5f);
        super.render(pEntity,pEntityYaw,pPartialTicks,pMatrixStack,pBuffer,pPackedLight);
    }

}
