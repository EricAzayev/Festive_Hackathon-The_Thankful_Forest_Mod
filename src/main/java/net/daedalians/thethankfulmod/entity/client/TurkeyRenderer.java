package net.daedalians.thethankfulmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.daedalians.thethankfulmod.TheThankfulMod;
import net.daedalians.thethankfulmod.entity.custom.TurkeyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TurkeyRenderer extends MobRenderer<TurkeyEntity, TurkeyModel<TurkeyEntity>> {
    public TurkeyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TurkeyModel<>(pContext.bakeLayer(ModModelLayers.TURKEY_LAYER)), .5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TurkeyEntity turkeyEntity) {
        return new ResourceLocation(TheThankfulMod.MOD_ID, "textures/entity/turkey.png");
    }

    @Override
    public void render(TurkeyEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight){
        if(pEntity.isBaby()){
            // Changes the size of the entity
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity,pEntityYaw,pPartialTicks,pMatrixStack,pBuffer,pPackedLight);
    }

}
