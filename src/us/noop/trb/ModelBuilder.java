package us.noop.trb;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * A gigantic class containing utility methods for animating and initially creating a trebuchet.
 * The trebuchet can be facing any direction because of the add(), vectorCorrect(), and correct() methods.
 * 
 * btw fuck schemas
 * @author zeu06
 *
 */
public class ModelBuilder {
	
	/**
	 * The main plugin object
	 */
	private Trebuchet trb;
	
	/**
	 * Constructor. Only instantiates a ModelBuilder object.
	 * @param trebuchet - main plugin object
	 */
	public ModelBuilder(Trebuchet trebuchet) {
		trb = trebuchet;
	}
	
	/**
	 * 
	 * @param baseBlock - the base block of the trebuchet to be created.
	 * @param p - the blockface that faced the player when the trebuchet was created (it faces the opposite direction of the trebuchet).
	 */
	@SuppressWarnings("deprecation")
	public void construct(Block baseBlock, BlockFace p){
		MapTrebuchet mp = trb.manager.add(baseBlock.getWorld(), baseBlock.getLocation(), face2int(p));
		World w = baseBlock.getWorld();
		Location l = baseBlock.getLocation().clone();
		w.getBlockAt(l).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 4), false);
		w.getBlockAt(add(p, l, -1, 0, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, -1, 0, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 4), false);
		w.getBlockAt(add(p, l, -1, 0, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 4), false);
		w.getBlockAt(add(p, l, -1, 0, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 4), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 1), false);
		w.getBlockAt(add(p, l, 1, 0, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 1), false);
		w.getBlockAt(add(p, l, 1, 0, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 4), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD_BUTTON.getId(), (byte) correct(Material.WOOD_BUTTON, p, 3), false);
		w.getBlockAt(add(p, l, -1, -1, 0)).setTypeIdAndData(Material.WOOD_BUTTON.getId(), (byte) correct(Material.WOOD_BUTTON, p, 1), false);
		w.getBlockAt(add(p, l, 1, -1, 0)).setTypeIdAndData(Material.WOOD_BUTTON.getId(), (byte) correct(Material.WOOD_BUTTON, p, 4), false);
		w.getBlockAt(add(p, l, 0, 1, 1)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 1), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.LOG_2.getId(), (byte) correct(Material.LOG_2, p, 5), false);
		w.getBlockAt(add(p, l, 0, -2, -6)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, -4, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 1), false);
		w.getBlockAt(add(p, l, 1, -2, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 1, -1, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 1, 0, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 1, 0, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, -1, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 1, 0, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 4), false);
		w.getBlockAt(add(p, l, 0, -2, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 1, 1, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 4), false);
		w.getBlockAt(add(p, l, 1, 0, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 4), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 0), false);
		w.getBlockAt(add(p, l, -1, 0, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 0), false);
		w.getBlockAt(add(p, l, -1, 0, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 5), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.WOOD_BUTTON.getId(), (byte) correct(Material.WOOD_BUTTON, p, 4), false);
		w.getBlockAt(add(p, l, 1, 1, 0)).setTypeIdAndData(Material.WOOD_BUTTON.getId(), (byte) correct(Material.WOOD_BUTTON, p, 2), false);
		w.getBlockAt(add(p, l, -1, 1, 0)).setTypeIdAndData(Material.WOOD_BUTTON.getId(), (byte) correct(Material.WOOD_BUTTON, p, 3), false);
		w.getBlockAt(add(p, l, 0, -1, 1)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 0), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.LOG_2.getId(), (byte) correct(Material.LOG_2, p, 5), false);
		w.getBlockAt(add(p, l, -1, 0, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, -1, -2)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, 2, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, -1, -1)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 2, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 1, -1)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, 2, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 1, 0, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 1, -1, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, -2, 0, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, 2, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, -2, 0, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 1, 0, 0)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 4), false);
		w.getBlockAt(add(p, l, 1, -4, 1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, -2, 0, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, 2, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 2)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 8), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 2, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 1, 0, 0)).setTypeIdAndData(Material.LOG_2.getId(), (byte) correct(Material.LOG_2, p, 5), false);
		w.getBlockAt(add(p, l, -1, 1, 0)).setTypeIdAndData(Material.SPRUCE_WOOD_STAIRS.getId(), (byte) correct(Material.SPRUCE_WOOD_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, -1, 1)).setType(Material.LOG);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 1, false);
		w.getBlockAt(add(p, l, 0, -6, -7)).setTypeIdAndData(Material.LEVER.getId(), (byte) correct(Material.LEVER, p, 13), false);
		w.getBlockAt(add(p, l, -1, -2, -1)).setTypeIdAndData(Material.WALL_SIGN.getId(), (byte) correct(Material.WALL_SIGN, p, 5), false);
		Sign s = (Sign) w.getBlockAt(l).getState();
		s.setLine(0, "[trebuchet]");
		s.setLine(1, "up/down");
		s.setLine(2, mp.getU() + "");
		s.update();
		w.getBlockAt(add(p, l, 1, -1, 0)).setTypeIdAndData(Material.WALL_SIGN.getId(), (byte) correct(Material.WALL_SIGN, p, 2), false);
		s = (Sign) w.getBlockAt(l).getState();
		s.setLine(0, "[trebuchet]");
		s.setLine(1, "left/right");
		s.setLine(2, mp.getL() + "");
		s.update();
		buildReloading(mp, p);
		buildReady(mp, p);
	}
	
	/**
	 * Adds numbers to a location that is part of a trebuchet. The direction of the trebuchet is taken into account
	 * @param b - the blockface that faced the player when the trebuchet was created (it faces the opposite direction of the trebuchet).
	 * @param l - location to be added to
	 * @param x - x to add
	 * @param y - y to add
	 * @param z - z to add
	 * @return - arg l + (x,y,z)
	 */
	public static Location add(BlockFace b, Location l, int x, int y, int z){
		switch(b){
		case NORTH:
			return l.add(-x, z, y);
		case EAST:
			return l.add(-y, z, -x);
		case SOUTH:
			return l.add(x, z, -y);
		case WEST:
			return l.add(y, z, x);
		default: return l;
		}
	}
	
	/**
	 * Modifies a vector to face a certain direction 
	 * @param t - direction. n=0, e=1, s=2, w=3. This is similar to blockface in that it is the opposite of where the trebuchet is facing.
	 * @param x - x value of the vector when it faces south (direction = 0)
	 * @param y - y value of the vector when it faces south
	 * @param z - z value of the vector when it faces south
	 * @return
	 */
	public static Vector vectorCorrect(int t, double x, double y, double z){
		Vector v = new Vector(x, y, z);
		BlockFace b = int2face(t);
		switch(b){
		case NORTH:
			v.setX(-x);
			v.setY(z);
			v.setZ(y);
			break;
		case EAST:
			v.setX(-y);
			v.setY(z);
			v.setZ(-x);
			break;
		case SOUTH:
			v.setX(x);
			v.setY(z);
			v.setZ(-y);
			break;
		case WEST:
			v.setX(y);
			v.setY(z);
			v.setZ(x);
			break;
		default: return v;
		}
		return v;
	}
	
	/**
	 * see other add method. Everything is the same except for b.
	 * @param b - direction. n=0, e=1, s=2, w=3. This is similar to blockface in that it is the opposite of where the trebuchet is facing.
	 * @param l
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static Location add(int b, Location l, int x, int y, int z){
		return add(int2face(b), l, x, y, z);
	}
	
	/**
	 * Converts a blockface into a number for easier storage.
	 * n=0, e=1, s=2, w=3
	 * @param f
	 * @return
	 */
	public static int face2int(BlockFace f){
		try{
			f.name();
		}catch(Exception e){
			Bukkit.getServer().broadcastMessage("ALERT TO WHOEVER WANTED TO MODIFY A TREBUCHET: ");
			Bukkit.getServer().broadcastMessage("YOU MUST BE STANDING RIGHT NEXT TO THE BLOCK!");
			Bukkit.getServer().broadcastMessage("YOU CAN FIND YOUR LOCATION BY PRESSING H AND F3");
			Bukkit.getServer().broadcastMessage("THEN LOOK STRAIGHT DOWN. THE LOCATION OF THE");
			Bukkit.getServer().broadcastMessage("COLORED THING IS YOUR LOCATION! IT MUST BE ON AN");
			Bukkit.getServer().broadcastMessage("ADJACENT BLOCK");
		}
		switch(f){
		case NORTH:
			return 0;
		case EAST:
			return 1;
		case SOUTH:
			return 2;
		case WEST:
			return 3;
		default: throw new NumberFormatException("OH NOES");
		}
	}
	
	/**
	 * Opposite of face2int.
	 * @param i
	 * @return
	 */
	public static BlockFace int2face(int i){
		switch(i){
		case 0: return BlockFace.NORTH;
		case 1: return BlockFace.EAST;
		case 2: return BlockFace.SOUTH;
		case 3: return BlockFace.WEST;
		default: return BlockFace.NORTH;
		}
	}
	
	/**
	 * Corrects the data of blocks to proper directional blocks used in trebuchet creation.
	 * The blocks inputted are the ones with data values suited to south-facing trebuchets (b=NORTH)
	 * @param m - the material of the directional block
	 * @param b - the opposite of the direction of the trebuchet
	 * @param s - the data value when the trebuchet has BlockFace=NORTH
	 * @return - corrected int
	 */
	public int correct(Material m, BlockFace b, int s){
		if(m == Material.LOG || m == Material.LOG_2){
			if(b == BlockFace.EAST || b == BlockFace.WEST){
				if(s == 4) return 8;
				if(s == 8) return 4;
				if(s == 5) return 9;
				if(s == 9) return 5;
				return s;
			}else{
				return s;
			}
		}else if(m == Material.SPRUCE_WOOD_STAIRS || m == Material.DARK_OAK_STAIRS){
		switch(b){
		case SOUTH:
			if(s == 0) return 1;
			if(s == 1) return 0;
			if(s == 2) return 3;
			if(s == 3) return 2;
			if(s == 4) return 5;
			if(s == 5) return 4;
			if(s == 6) return 7;
			if(s == 7) return 6;
			break;
		case NORTH: 
			return s;
		case EAST:
			if(s == 3) return 0;
			if(s == 0) return 2;
			if(s == 2) return 1;
			if(s == 1) return 3;
			if(s == 6) return 5;
			if(s == 7) return 4;
			if(s == 5) return 7;
			if(s == 4) return 6;
			break;
		case WEST:
			if(s == 3) return 1;
			if(s == 0) return 3;
			if(s == 2) return 0;
			if(s == 1) return 2;
			if(s == 4) return 7;
			if(s == 7) return 5;
			if(s == 5) return 6;
			if(s == 6) return 4;
			break;
		default:
			return s;
			}
		}else if(m == Material.WOOD_BUTTON){
			switch(b){
			case SOUTH: 
				if(s == 1) return 2;
				if(s == 2) return 1;
				if(s == 3) return 4;
				if(s == 4) return 3;
				break;
			case NORTH:
				return s;
			case WEST:
				if(s == 3) return 1;
				if(s == 1) return 4;
				if(s == 4) return 2;
				if(s == 2) return 3;
				break;
			case EAST:
				if(s == 2) return 4;
				if(s == 1) return 3;
				if(s == 4) return 1;
				if(s == 3) return 2;
				break;
			default: return s;
			}
		}else if(m == Material.FENCE_GATE){
			if(b == BlockFace.EAST || b == BlockFace.WEST){
				if(s == 1) return 0;
				return 1;
			}else{
				return s;
			}
		}else if(m == Material.TRAP_DOOR){
			switch(b){
			case WEST:
				if(s == 5) return 7;
				if(s == 2) return 1;
				if(s == 8) return 10;
				if(s == 7) return 4;
				if(s == 4) return 6;
				if(s == 6) return 5;
			case EAST:
				if(s == 2) return 0;
				if(s == 5) return 6;
				if(s == 8) return 11;
				if(s == 6) return 4;
				if(s == 4) return 7;
				if(s == 7) return 5;
			case NORTH:
				return s;
			case SOUTH:
				if(s == 2) return 3;
				if(s == 5) return 4;
				if(s == 8) return 9;
				if(s == 7) return 6;
				if(s == 6) return 7;
				if(s == 4) return 5;
			default: return s;
			}
		}else if(m == Material.LEVER){
			switch(b){
			case WEST:
				if(s == 13) return 14;
				if(s == 5) return 6;
			case EAST:
				if(s == 13) return 6;
				if(s == 5) return 14;
			case NORTH: 
				return s;
			case SOUTH:
				if(s == 13) return 5;
				if(s == 5) return 13;
			default: return s;
			}
		}else if(m == Material.WALL_SIGN){
			switch(b){
			case WEST:
				if(s == 5) return 2;
				if(s == 2) return 4;
			case EAST:
				if(s == 5) return 3;
				if(s == 2) return 5;
			case NORTH: 
				return s;
			case SOUTH:
				if(s == 5) return 4;
				if(s == 2) return 3;
			default: return s;
			}
		}
		return 0;
	}
	
	/**
	 * Places the stone when it is ready to be launched again
	 * @param mp
	 * @param p
	 */
	@SuppressWarnings("deprecation")
	public void buildReady(MapTrebuchet mp, BlockFace p){
		World w = mp.getBase().getWorld();
		Location l = mp.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -2, 1)).setTypeIdAndData(Material.STONE.getId(), (byte) 6, false);
	}
	
	/**
	 * Constructs the reloading look for a trebuchet.
	 * @param mp
	 * @param p
	 */
	@SuppressWarnings("deprecation")
	public void buildReloading(MapTrebuchet mp, BlockFace p){
		World w = mp.getBase().getWorld();
		Location l = mp.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -8, 7)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -2)).setType(Material.AIR);
		w.getBlockAt(add(p, l, -1, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 1, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 1, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, -1, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -2, 5)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.AIR);
		l = mp.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -5, 1)).setTypeIdAndData(Material.FENCE_GATE.getId(), (byte) correct(Material.FENCE_GATE, p, 1), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.FENCE_GATE.getId(), (byte) correct(Material.FENCE_GATE, p, 1), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.FENCE_GATE.getId(), (byte) correct(Material.FENCE_GATE, p, 1), false);
		w.getBlockAt(add(p, l, 0, 2, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 5), false);
		w.getBlockAt(add(p, l, 0, -1, 1)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 2), false);
		l = mp.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -6, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.WOOD_STEP.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.IRON_FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 9), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 1), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 9), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 1), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, -1)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
	}
	
	/**
	 * Constructs the middle look of the animation of a trebuchet.
	 * @param mp
	 * @param p
	 */
	@SuppressWarnings("deprecation")
	public void buildReloadingMid(MapTrebuchet mp, BlockFace p){
		World w = mp.getBase().getWorld();
		Location l = mp.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -8, 16)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, -1, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 1, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 1, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, -1, 0, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.AIR);
		l = mp.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -8, 7)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.BARRIER);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.BARRIER);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 8), false);
		w.getBlockAt(add(p, l, -1, 0, 1)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 7), false);
		w.getBlockAt(add(p, l, 1, 1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 5), false);
		w.getBlockAt(add(p, l, 1, -1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 6), false);
		w.getBlockAt(add(p, l, -1, -1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 4), false);
		w.getBlockAt(add(p, l, 0, 0, 4)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.IRON_FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 9), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 1), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 9), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 1), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, -1)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		
	}
	
	/**
	 * Constructs the middle look of the animation of a trebuchet.
	 * @param mp
	 * @param p
	 */
	@SuppressWarnings("deprecation")
	public void buildMid(MapTrebuchet mp, BlockFace p){
		World w = mp.getBase().getWorld();
		Location l = mp.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -6, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.AIR);
		l = mp.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -5, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 2, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -1, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		l = mp.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -8, 7)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.STONE.getId(), (byte) 6, false);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.BARRIER);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 8), false);
		w.getBlockAt(add(p, l, -1, 0, 1)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 7), false);
		w.getBlockAt(add(p, l, 1, 1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 5), false);
		w.getBlockAt(add(p, l, 1, -1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 6), false);
		w.getBlockAt(add(p, l, -1, -1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 4), false);
		w.getBlockAt(add(p, l, 0, 0, 4)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.IRON_FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 9), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 1), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 9), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 1), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, -1)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		
	}
	
	/**
	 * Deletes the middle block arrangement and creates the launching arrangement
	 * @param mapTrebuchet - the trebuchet to be operated on
	 * @param p - the blockface that is facing the opposite direction as the trebuchet.
	 */
	@SuppressWarnings("deprecation")
	public void buildLaunching(MapTrebuchet mapTrebuchet, BlockFace p){
		World w = mapTrebuchet.getBase().getWorld();
		Location l = mapTrebuchet.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -8, 7)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -2)).setType(Material.AIR);
		w.getBlockAt(add(p, l, -1, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 1, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 1, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, -1, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -2, 5)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, -1, 0)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 0, 1)).setType(Material.AIR);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.AIR);
		l = mapTrebuchet.getBase().getLocation().clone();
		w.getBlockAt(add(p, l, 0, -7, 16)).setType(Material.BARRIER);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 4), false);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.BARRIER);
		w.getBlockAt(add(p, l, -1, 0, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 7), false);
		w.getBlockAt(add(p, l, 1, 1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 5), false);
		w.getBlockAt(add(p, l, 1, -1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 6), false);
		w.getBlockAt(add(p, l, -1, -1, 0)).setTypeIdAndData(Material.TRAP_DOOR.getId(), (byte) correct(Material.TRAP_DOOR, p, 4), false);
		w.getBlockAt(add(p, l, 0, 1, -1)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 1, 0)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.FENCE);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setType(Material.IRON_FENCE);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 9), false);
		w.getBlockAt(add(p, l, 0, 1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 3), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 1), false);
		w.getBlockAt(add(p, l, 0, 0, -1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 7), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 9), false);
		w.getBlockAt(add(p, l, 0, -1, 0)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 6), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.LOG.getId(), (byte) correct(Material.LOG, p, 1), false);
		w.getBlockAt(add(p, l, 0, 0, 1)).setTypeIdAndData(Material.DARK_OAK_STAIRS.getId(), (byte) correct(Material.DARK_OAK_STAIRS, p, 2), false);
		w.getBlockAt(add(p, l, 0, 1, -1)).setTypeIdAndData(Material.WOOD.getId(), (byte) 5, false);
	}
	/**
	 * Removes a trebuchet object from the manager based on its base block position.
	 * @param baseBlock - the block selected by the player, which SHOULD be the base block of a trebuchet
	 * @param player - player who requested deletion
	 */
	public void destroy(Block baseBlock, Player player){
			trb.manager.remove(baseBlock.getWorld(), baseBlock);
			player.sendMessage("TREBUCHET AT " + baseBlock.getLocation().toString() + " HAS BEEN DESTROYED IF IT EXISTED IN THE FIRST PLACE");
		}
	}
