package us.noop.trb;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Event listener for trebuchet-related events.
 * @author zeu06
 *
 */
public class TrebuchetEvent implements Listener{
	
	/**
	 * TrebuchetManager
	 */
	private TrebuchetManager manager;
	
	/**
	 * Constructor.
	 * @param m
	 */
	public TrebuchetEvent(TrebuchetManager m){
		this.manager = m;
	}
	
	/**
	 * Method called on interaction with blocks. Reacts only to levers associated with trebuchets and also signs with [trebuchet] written
	 * @param e
	 */
	@EventHandler(priority = EventPriority.LOWEST)
	public void onTrbInteract(PlayerInteractEvent e){
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK){
			if(e.getClickedBlock().getType() == Material.WALL_SIGN){
				Sign s = (Sign) e.getClickedBlock().getState();
				if(s.getLine(0).equals("[trebuchet]")){
					if(s.getLine(1).equals("up/down")){
						MapTrebuchet trebuchet = manager.getTrebuchetByDiffLoc(e.getClickedBlock().getLocation(), 2, 8, 0);
						if(trebuchet == null){
							return;
						}
						switch(e.getAction()){
						case RIGHT_CLICK_BLOCK:
							if(trebuchet.getU() < Config.TREBUCHET_MAX_UD)
								trebuchet.addU(1);
							break;
						case LEFT_CLICK_BLOCK:
							if(trebuchet.getU() > Config.TREBUCHET_MIN_UD)
								trebuchet.addU(-1);
							break;
						default: break;
						}
						s.setLine(2, trebuchet.getU() + "");
						s.update();
					}else if(s.getLine(1).equals("left/right")){
						MapTrebuchet trebuchet = manager.getTrebuchetByDiffLoc(e.getClickedBlock().getLocation(), 1, 9, 0);
						if(trebuchet == null){
							return;
						}
						switch(e.getAction()){
						case RIGHT_CLICK_BLOCK:
							if(trebuchet.getL() < Config.TREBUCHET_MAX_LR)
								trebuchet.addL(1);
							break;
						case LEFT_CLICK_BLOCK:
							if(trebuchet.getL() > Config.TREBUCHET_MIN_LR)
								trebuchet.addL(-1);
							break;
						default: break;
						}
						s.setLine(2, trebuchet.getL() + "");
						s.update();
					}
				}
				
			}else if(e.getClickedBlock().getType() == Material.LEVER){
				MapTrebuchet trebuchet = manager.getTrebuchetByDiffLoc(e.getClickedBlock().getLocation(), 1, 6, -1);
				if(trebuchet == null){
					return;
				}
				if(trebuchet.isReloading()){
					e.setCancelled(true);
					e.getPlayer().sendMessage("This trebuchet is reloading.");
					return;
				}
				//:D
				manager.launch(trebuchet);
			}
		}
	}
	
	/**
	 * Called when the stone lands. Stone is deleted and an explosion happens!
	 * The stone is recognized by metadata set when it is launched.
	 * @param e
	 */
	@EventHandler(priority = EventPriority.HIGH)
	public void onStoneLand(EntityChangeBlockEvent e){
		if(e.getEntity() instanceof FallingBlock){
			if(((FallingBlock) e.getEntity()).hasMetadata("us.noop.trb.stone")){
				e.getBlock().getLocation().getWorld().createExplosion(e.getBlock().getLocation(), (float) Config.TREBUCHET_EXPLOSION_INTENSITY);
				e.setCancelled(true);
				e.getEntity().remove();
			}
		}
	}
}
