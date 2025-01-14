package rynnavinx.sspb.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rynnavinx.sspb.client.gui.SSPBGameOptions;
import rynnavinx.sspb.reflection.ReflectionAoFaceData;
import rynnavinx.sspb.reflection.ReflectionSmoothLightPipeline;


@Environment(EnvType.CLIENT)
public class SSPBClientMod implements ClientModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("SSPB");
	private static SSPBGameOptions CONFIG;


	public static SSPBGameOptions options() {
		return CONFIG;
	}

	@Override
	public void onInitializeClient() {
		try {
			ReflectionAoFaceData.InitReflectionAoFaceData();
			ReflectionSmoothLightPipeline.InitReflectionSmoothLightPipeline();

			CONFIG = SSPBGameOptions.load();
			CONFIG.updateShadowyness(CONFIG.shadowynessPercent);

			LOGGER.info("[SSPB] Broken dirt path lighting is best dirt path lighting lol");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
