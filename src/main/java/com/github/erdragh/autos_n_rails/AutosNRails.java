package com.github.erdragh.autos_n_rails;

import com.github.erdragh.autos_n_rails.config.AutosNRailsConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutosNRails implements ModInitializer {
    public static final String MODID = "autos_n_rails";

    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static AutosNRailsConfig config;

    @Override
    public void onInitialize() {
        AutoConfig.register(AutosNRailsConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(AutosNRailsConfig.class).getConfig();
        LOGGER.info("Using temporary Myron fix for following mod ids:");
        LOGGER.info("\"" + String.join("\"; \"", config.getFixedModIDs()) + "\"");
    }
}
