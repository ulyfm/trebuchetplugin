package us.noop.trb;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * Stores data values determined by config that can be accessed by any class.
 * @author zeu06
 *
 */
public class Config {
	public static double TREBUCHET_POWER = 6;
	public static double TREBUCHET_EXPLOSION_INTENSITY = 3.1;
	public static long TREBUCHET_RELOAD_TIME = 200l;
	public static long TREBUCHET_PARTIAL_RELOAD_TIME = 720l;
	public static int TREBUCHET_DEFAULT_UD = 45;
	public static int TREBUCHET_DEFAULT_LR = 0;
	public static int TREBUCHET_MIN_LR = -45;
	public static int TREBUCHET_MAX_LR = 45;
	public static int TREBUCHET_MIN_UD = 10;
	public static int TREBUCHET_MAX_UD = 75;
	public static String TREBUCHET_SAVE_FILEPATH = "plugins/TrebuchetMod/trbcfg.cfg";
	public static void load(FileConfiguration cfg) {
		TREBUCHET_POWER = cfg.getDouble("trebuchetpower");
		TREBUCHET_RELOAD_TIME = cfg.getInt("reloadticks");
		TREBUCHET_PARTIAL_RELOAD_TIME = cfg.getInt("partialreloadticks");
		TREBUCHET_DEFAULT_UD = cfg.getInt("defaultudangle");
		TREBUCHET_DEFAULT_LR = cfg.getInt("defaultlrangle");
		TREBUCHET_SAVE_FILEPATH  = cfg.getString("savepath");
		TREBUCHET_MIN_LR = cfg.getInt("minlrangle");
		TREBUCHET_MAX_LR = cfg.getInt("maxlrangle");
		TREBUCHET_MIN_UD = cfg.getInt("minudangle");
		TREBUCHET_MAX_UD = cfg.getInt("maxudangle");
		TREBUCHET_EXPLOSION_INTENSITY = cfg.getDouble("explosionintensity");
		
	}
}
