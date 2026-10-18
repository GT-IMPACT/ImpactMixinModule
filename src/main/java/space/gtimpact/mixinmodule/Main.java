package space.gtimpact.mixinmodule;

import static space.gtimpact.mixinmodule.Main.*;

import cpw.mods.fml.common.Mod;

@Mod(modid = MODID, version = VERSION, name = MODNAME, acceptedMinecraftVersions = "[1.7.10]")
public class Main {
    public static final String MODID = BuildConfig.MODID;
    public static final String MODNAME = BuildConfig.MODNAME;
    public static final String VERSION = BuildConfig.VERSION;
    public static final String GROUPNAME = BuildConfig.GROUPNAME;
}
