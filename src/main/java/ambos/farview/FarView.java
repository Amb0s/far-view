package ambos.farview;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FarView implements ModInitializer {
    public static final String MOD_ID = "farview";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static String name(String name) {
        return FarView.MOD_ID + "." + name;
    }

    @Override
    public void onInitialize() {
        LOGGER.info("FarView initialized");
    }
}
