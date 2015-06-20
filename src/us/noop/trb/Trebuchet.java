package us.noop.trb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class. Loads config, sets up events, and sets up commands.
 * @author zeu06
 *
 */
public class Trebuchet extends JavaPlugin {
	
	/**
	 * ModelBuilder (only one)
	 */
	public ModelBuilder builder;
	
	/**
	 * TrebuchetManager (only one)
	 */
	public TrebuchetManager manager;
	
	/**
	 * Enable method
	 */
	@Override
	public void onEnable(){
		this.saveDefaultConfig();
		builder = new ModelBuilder(this);
		manager = new TrebuchetManager(this);
		Config.load(this.getConfig());
		String trbfilepath = Config.TREBUCHET_SAVE_FILEPATH;
		try {
			File f = new File(trbfilepath);
			if(!f.exists()){
				f.createNewFile();
				PrintStream p = new PrintStream(f);
				p.print(0);
				p.close();
			}
			Scanner sc = new Scanner(f);
			int numWorlds = Integer.parseInt(sc.nextLine());
			for(int i = 0; i < numWorlds; ++i){
				String world = sc.nextLine();
				ArrayList<MapTrebuchet> worldtrb = new ArrayList<MapTrebuchet>();
				int numTrbs = Integer.parseInt(sc.nextLine());
				for(int j = 0; j < numTrbs; ++j){
					int x = Integer.parseInt(sc.nextLine());
					int y = Integer.parseInt(sc.nextLine());
					int z = Integer.parseInt(sc.nextLine());
					int t = Integer.parseInt(sc.nextLine());
					int u = Config.TREBUCHET_DEFAULT_UD;
					int l = Config.TREBUCHET_DEFAULT_LR;
					worldtrb.add(new MapTrebuchet(Bukkit.getWorld(world), x, y, z, t, u, l));
				}
				manager.put(Bukkit.getWorld(world), worldtrb);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.getServer().getPluginManager().registerEvents(new TrebuchetEvent(manager), this);
	}
	
	/**
	 * Disable method.
	 */
	@Override
	public void onDisable(){
		String trbfilepath = Config.TREBUCHET_SAVE_FILEPATH;
		try {
			File f = new File(trbfilepath);
			if(!f.exists()){
				f.createNewFile();
				PrintStream p = new PrintStream(f);
				p.print(0);
				p.close();
			}
			PrintStream ps = new PrintStream(new File(trbfilepath));
			ps.println(manager.numWorlds());
			for(World w : manager.trebuchets.keySet()){
				ps.println(w.getName());
				ArrayList<MapTrebuchet> worldtrb = manager.trebuchets.get(w);
				ps.println(worldtrb.size());
				for(MapTrebuchet m : worldtrb){
					ps.println(m.getX());
					ps.println(m.getY());
					ps.println(m.getZ());
					ps.println(m.getT());
				}
			}
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method called on command
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try{
		if(label.equalsIgnoreCase("trbcreate")){
			Player p = (Player) sender;
			if(!p.isOp()) return true;
			Block b = p.getTargetBlock((Set<Material>) null, 2);
			if(b == null){
				p.sendMessage("OUTSIDE OF TREBUCHET BASE BLOCK RANGE");
				return true;
			}
			if(b.getType().equals(Material.BEDROCK)){
				builder.construct(b, b.getFace(p.getLocation().getWorld().getBlockAt(p.getLocation())));
			}
			return true;
		}else if(label.equalsIgnoreCase("trbdestroy")){
			Player p = (Player) sender;
			if(!p.isOp()) return true;
			Block b = p.getTargetBlock((Set<Material>) null, 2);
			if(b == null){
				p.sendMessage("OUTSIDE OF TREBUCHET BASE BLOCK RANGE");
				return true;
			}
			if(b.getType().equals(Material.BEDROCK)){
				builder.destroy(b, p);
			}
			return true;
		}
		return false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}