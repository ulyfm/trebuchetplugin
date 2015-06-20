package us.noop.trb;

import org.bukkit.World;
import org.bukkit.block.Block;

/**
 * Class to store the data of a trebuchet on the map.
 * @author zeu06
 *
 */
public class MapTrebuchet {
	
	/**
	 * Individual values
	 */
	private int x, y, z, t, u, l;
	
	/**
	 * Base block (the block that you looked at when the trebuchet was created (now a log, formerly bedrock)
	 */
	private Block base;
	
	/**
	 * Is the trebuchet reloading? This value should be checked to make sure it's okay to fire.
	 */
	private boolean reloading = false;
	
	/**
	 * Constructor
	 * @param w
	 * @param x
	 * @param y
	 * @param z
	 * @param t
	 * @param u
	 * @param l
	 */
	public MapTrebuchet(World w, int x, int y, int z, int t, int u, int l) {
		this.x = x;
		this.z = z;
		this.y = y;
		this.t = t;
		this.u = u;
		this.l = l;
		this.base = w.getBlockAt(x, y , z);
	}
	
	/**
	 * Base block
	 * @return
	 */
	public Block getBase(){
		return base;
	}
	
	/**
	 * u/d angle
	 * @param a
	 */
	public void addU(int a){
		u += a;
	}
	
	/**
	 * l/r angle
	 * @param a
	 */
	public void addL(int a){
		l += a;
	}
	
	/**
	 * x location of base block
	 * @return
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * y location of base block
	 * @return
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * z location of base block
	 * @return
	 */
	public int getZ(){
		return z;
	}
	public int getT(){
		return t;
	}
	public int getU(){
		return u;
	}
	public int getL(){
		return l;
	}
	public boolean isReloading() {
		return reloading;
	}
	public void setReloading(boolean r){
		reloading = r;
	}
}
