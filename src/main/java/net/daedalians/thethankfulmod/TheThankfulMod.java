package net.daedalians.thethankfulmod;

//import com.example.examplemod.Config;
import com.mojang.logging.LogUtils;
//<<<<<<< HEAD
import net.daedalians.thethankfulmod.block.ModBlocks;
import net.daedalians.thethankfulmod.entity.client.TurkeyBossRenderer;
import net.daedalians.thethankfulmod.item.ModCreativeModTabs;
import net.daedalians.thethankfulmod.item.ModItems;
//=======
import net.daedalians.thethankfulmod.entity.client.TurkeyRenderer;
//>>>>>>> d33797dcf909eb64f45956bae3ef9f6fbcb6ed30
import net.daedalians.thethankfulmod.sound.ModSounds;
import net.daedalians.thethankfulmod.worldgen.biome.ModTerrablender;
import net.daedalians.thethankfulmod.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TheThankfulMod.MOD_ID)
public class TheThankfulMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "the_thankful_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public TheThankfulMod(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);
        ModTerrablender.registerBiomes();

        // Register the mod sounds
        ModSounds.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);





        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        //context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS){
            event.accept(ModItems.TURKEY_BOSS_EGG);
            event.accept(ModItems.TURKEY_EGG);
        }
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            //event.accept(ModItems.FALL_SAPLING);
            event.accept(ModItems.SAPPHIRE);
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            event.accept(ModBlocks.FALL_LEAVES);
            event.accept(ModBlocks.FALL_GRASS);
            event.accept(ModBlocks.SCATTERED_LEAVES);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.FALL_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SCATTERED_LEAVES.get(), RenderType.cutout());
            EntityRenderers.register(ModEntities.TURKEY.get(), TurkeyRenderer::new);
            EntityRenderers.register(ModEntities.TURKEY_BOSS.get(), TurkeyBossRenderer::new);
        }
    }
}
