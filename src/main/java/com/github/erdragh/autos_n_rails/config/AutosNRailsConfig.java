package com.github.erdragh.autos_n_rails.config;

import com.github.erdragh.autos_n_rails.AutosNRails;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.Arrays;

@Config(name = AutosNRails.MODID)
public class AutosNRailsConfig implements ConfigData {
    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    private String fixedModIDs = "railways,create";

    public String[] getFixedModIDs() {
        return this.fixedModIDs.split(", ?");
    }

    public boolean shouldFixModID(String modid) {
        return Arrays.asList(this.getFixedModIDs()).contains(modid);
    }
}
