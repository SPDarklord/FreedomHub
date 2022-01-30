package net.freedom.dev.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class LaunchPads implements Listener{
	@SuppressWarnings("deprecation")
	@EventHandler
	  public void onPlayerMove(PlayerMoveEvent event)
	  {
	    Player player = event.getPlayer();
	    Location playerLoc = player.getLocation();
	    @SuppressWarnings("unused")
		int ID = playerLoc.getWorld().getBlockAt(playerLoc).getRelative(0, -1, 0).getTypeId();
	    int plate = playerLoc.getWorld().getBlockAt(playerLoc).getTypeId();
	    
	     
	        if (plate == 70)
	        {
	          player.setVelocity(player.getLocation().getDirection().multiply(4.5));
	          player.setVelocity(new Vector(player.getVelocity().getX(), 1.8D, player.getVelocity().getZ()));
	          player.playSound(player.getLocation(), Sound.BAT_TAKEOFF, 1.0F, 1.0F);
	          for (Player all : Bukkit.getOnlinePlayers()) {
	            all.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 4);
	          }
	        
	      }
	    
	  }
}
