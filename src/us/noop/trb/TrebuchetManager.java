package us.noop.trb;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

/**
 * 
 * @author zeu06
 *
 */
public class TrebuchetManager {
	
	/**
	 * Hash of worlds > trebuchets in that world
	 */
	public HashMap<World, ArrayList<MapTrebuchet>> trebuchets = new HashMap<World, ArrayList<MapTrebuchet>>();
	
	/**
	 * plugin main object
	 */
	protected Trebuchet plugin;
	
	/**
	 * Constructor.
	 * @param p
	 */
	public TrebuchetManager(Trebuchet p){
		this.plugin = p;
	}
	
	/**
	 * Adds a group of trebuchets for a world.
	 * @param w
	 * @param t
	 */
	public void put(World w, ArrayList<MapTrebuchet> t){
		trebuchets.put(w, t);
	}
	
	/**
	 * number of keys in the hashmap
	 * @return
	 */
	public int numWorlds(){
		return trebuchets.keySet().size();
	}
	
	/**
	 * Adds a trebuchet to its appropriate list
	 * @param world
	 * @param l
	 * @param t
	 * @return
	 */
	public MapTrebuchet add(World world, Location l, int t) {
		MapTrebuchet mp = new MapTrebuchet(world, l.getBlockX(), l.getBlockY(), l.getBlockZ(), t, 25, 0);
		if(trebuchets.containsKey(world)){
			trebuchets.get(world).add(mp);
			return mp;
		}else{
			ArrayList<MapTrebuchet> mtrb = new ArrayList<MapTrebuchet>();
			mtrb.add(mp);
			trebuchets.put(world, mtrb);
			return mp;
		}
	}
	
	/**
	 * Removes a trebuchet from its list.
	 * @param world
	 * @param baseBlock
	 */
	public void remove(World world, Block baseBlock) {
		ArrayList<MapTrebuchet> mtrb = trebuchets.get(world);
		for(MapTrebuchet m : mtrb){
			if(m.getBase().getLocation().equals(baseBlock.getLocation())){
				mtrb.remove(m);
				break;
			}
		}
	}
	
	/**
	 * Gets a trebuchet by a different location modified based on direction
	 * @param otherLocation
	 * @param xMod
	 * @param yMod
	 * @param zMod
	 * @return
	 */
	public MapTrebuchet getTrebuchetByDiffLoc(Location otherLocation, int xMod, int yMod, int zMod){
		World w = otherLocation.getWorld();
		ArrayList<MapTrebuchet> possibleTrebuchets = trebuchets.get(w);
		for(MapTrebuchet m : possibleTrebuchets){
			Location theoreticalBaseBlock = ModelBuilder.add(m.getT(), otherLocation.clone(), xMod, yMod, zMod);
			if(m.getBase().getLocation().equals(theoreticalBaseBlock)){
				return m;
			}
		}
		return null;
	}
	
	/**
	 * Initializes launching animation.
	 * @param mt
	 */
	public void launch(MapTrebuchet mt){
		mt.setReloading(true);
		new LaunchAnimator(plugin, mt);
	}
}