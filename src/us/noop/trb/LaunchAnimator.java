package us.noop.trb;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FallingBlock;
import org.bukkit.metadata.FixedMetadataValue;

/**
 * Really gross class to set up async tasks for animation of stone launching
 * @author zeu06
 *
 */
public class LaunchAnimator {
	/**
	 * Trebuchet being animated
	 */
	private MapTrebuchet mt;
	
	/**
	 * Plugin main object
	 */
	private Trebuchet plugin;
	
	/**
	 * Constructor. Begins animation process.
	 * @param p - plugin main object
	 * @param m - trebuchet to be animated
	 */
	@SuppressWarnings("deprecation")
	public LaunchAnimator(Trebuchet p, MapTrebuchet m){
		mt = m;
		plugin = p;
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

			@Override
			public void run() {
				mt.getBase().getWorld().playSound(mt.getBase().getLocation(), Sound.ZOMBIE_WOODBREAK, 0.3f, 0.5f);
			}
			
		}, 4l);
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
			@Override
			public void run() {
				plugin.builder.buildMid(mt, ModelBuilder.int2face(mt.getT()));
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

					@Override
					public void run() {
						mt.getBase().getWorld().playSound(mt.getBase().getLocation(), Sound.GHAST_FIREBALL, 1f, 0.5f);
						plugin.builder.buildLaunching(mt, ModelBuilder.int2face(mt.getT()));
						FallingBlock fb = mt.getBase().getWorld().spawnFallingBlock(ModelBuilder.add(ModelBuilder.int2face(mt.getT()), mt.getBase().getLocation().clone(), 0, -7, 18), Material.STONE, (byte) 6);
						double yval = Math.sqrt(Config.TREBUCHET_POWER) * Math.cos(Math.toRadians(mt.getU()));
						double zval = yval * Math.tan(Math.toRadians(mt.getU()));
						fb.setVelocity(ModelBuilder.vectorCorrect(mt.getT(), Math.tan(Math.toRadians(mt.getL())), yval, zval));
						fb.setMetadata("us.noop.trb.stone", new FixedMetadataValue(plugin, "yes"));
						plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

							@Override
							public void run() {
								plugin.builder.buildReloadingMid(mt, ModelBuilder.int2face(mt.getT()));
							}
							
						}, 16l);
						plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

							@Override
							public void run() {
								plugin.builder.buildReloading(mt, ModelBuilder.int2face(mt.getT()));
							}
							
						}, Config.TREBUCHET_PARTIAL_RELOAD_TIME);
						plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

							@Override
							public void run() {
								mt.setReloading(false);
								plugin.builder.buildReady(mt, ModelBuilder.int2face(mt.getT()));
							}
							
						}, Config.TREBUCHET_RELOAD_TIME);
					}
					
				}, 6l);
			}
			
		}, 6l);
	}
}
