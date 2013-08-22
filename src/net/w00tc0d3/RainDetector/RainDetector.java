package net.w00tc0d3.RainDetector;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = RainDetector.modid, version = RainDetector.version, name = "RainDetector")
public class RainDetector {
	public static final String modid = "RainDetector";
	public static final String version = "0.1";
	
	public final static Block blockRainDetector = new BlockRainDetector(500).setUnlocalizedName("rainDetector");
	
	@Instance(RainDetector.modid)
	public static RainDetector rainDetector;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// do stuff
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerBlock(blockRainDetector, modid + blockRainDetector.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(blockRainDetector, "Rain Detector");
		
		GameRegistry.registerTileEntity(net.w00tc0d3.RainDetector.TileEntityRainDetector.class, "tileRainDetector");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// do stuff
	}
}
