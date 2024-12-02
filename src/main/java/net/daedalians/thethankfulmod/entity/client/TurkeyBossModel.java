package net.daedalians.thethankfulmod.entity.client;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.daedalians.thethankfulmod.entity.animations.TurkeyBossAnimations;
import net.daedalians.thethankfulmod.entity.custom.TurkeyBossEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class TurkeyBossModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "turkeybossbb"), "main");
	private final ModelPart turkey_boss;
	private final ModelPart leftWing;
	private final ModelPart leftLeg;
	private final ModelPart rightWing;
	private final ModelPart rightLeg;
	private final ModelPart head;
	private final ModelPart comb;
	private final ModelPart beak;
	private final ModelPart hat;
	private final ModelPart body;
	private final ModelPart tail_feathers;

	public TurkeyBossModel(ModelPart root) {
		this.turkey_boss = root.getChild("turkey_boss");
		this.leftWing = this.turkey_boss.getChild("wing1");
		this.leftLeg = this.turkey_boss.getChild("leg1");
		this.rightWing = this.turkey_boss.getChild("wing0");
		this.rightLeg = this.turkey_boss.getChild("leg0");
		this.head = this.turkey_boss.getChild("head");
		this.comb = this.head.getChild("comb");
		this.beak = this.head.getChild("beak");
		this.hat = this.head.getChild("hat");
		this.body = this.turkey_boss.getChild("body");
		this.tail_feathers = this.turkey_boss.getChild("tail_feathers");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition turkey_boss = partdefinition.addOrReplaceChild("turkey_boss", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leftWing = turkey_boss.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(46, 18).addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -11.0F, 0.0F));

		PartDefinition leftLeg = turkey_boss.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(33, 26).addBox(0.0F, 0.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, 1.0F));

		PartDefinition rightWing = turkey_boss.addOrReplaceChild("wing0", CubeListBuilder.create().texOffs(46, 18).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -11.0F, 0.0F));

		PartDefinition rightLeg = turkey_boss.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(33, 26).addBox(0.0F, 0.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, 1.0F));

		PartDefinition head = turkey_boss.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -11.0F, -2.0F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -4.0F));

		PartDefinition comb = head.addOrReplaceChild("comb", CubeListBuilder.create().texOffs(14, 4).addBox(-1.0F, -7.0F, -3.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(14, 0).addBox(-2.0F, -9.0F, -4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(18, 9).addBox(-2.0F, -29.0F, -6.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(29, 17).addBox(-3.0F, -22.0F, -7.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 4.0F));

		PartDefinition body = turkey_boss.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition tail_feathers = turkey_boss.addOrReplaceChild("tail_feathers", CubeListBuilder.create(), PartPose.offset(1.0F, -9.0F, 6.0F));

		PartDefinition cube_r1 = tail_feathers.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 0).addBox(-8.0F, -14.0F, -1.0F, 14.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(3.0F, -14.0F, -1.0F, 14.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r2 = tail_feathers.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 0).addBox(-8.0F, -14.0F, -1.0F, 14.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.turkey_boss.getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw,headPitch,ageInTicks);
		this.applyLegMovement(limbSwing,limbSwingAmount);
		this.animate(((TurkeyBossEntity)entity).attackAnimationState, TurkeyBossAnimations.ATTACK, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks){
		this.head.xRot = pHeadPitch * (float) (Math.PI / 180.0);
		this.head.yRot = pNetHeadYaw * (float) (Math.PI / 180.0);
	}

	private void applyLegMovement(float pLimbSwing, float pLimbSwingAmount){
		this.rightLeg.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
		this.leftLeg.xRot = Mth.cos(pLimbSwing * 0.6662F + (float) Math.PI) * 1.4F * pLimbSwingAmount;
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		turkey_boss.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return turkey_boss;
	}
}