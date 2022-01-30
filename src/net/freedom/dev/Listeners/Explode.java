package net.freedom.dev.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Explode implements Listener{

	@EventHandler
	  public void onExplosion(EntityExplodeEvent e)
	  {
		e.setCancelled(true);
	  }
	
}
