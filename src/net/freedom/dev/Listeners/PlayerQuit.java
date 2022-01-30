package net.freedom.dev.Listeners;

import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener{

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		e.setQuitMessage(null);
		if(Lists.get().Join.contains(e.getPlayer().getName())){
			Lists.get().Join.remove(e.getPlayer().getName());
		}
		if(Lists.get().vanish.contains(e.getPlayer().getName())){
			Lists.get().vanish.remove(e.getPlayer().getName());			
		}
		e.getPlayer().getInventory().clear();
		if(Lists.get().armour.contains(e.getPlayer().getName())){
			e.getPlayer().getInventory().setBoots(null);
			e.getPlayer().getInventory().setLeggings(null);
			e.getPlayer().getInventory().setChestplate(null);
			e.getPlayer().getInventory().setHelmet(null);
			e.getPlayer().getInventory().setArmorContents(null);
			Lists.get().armour.remove(e.getPlayer().getName());
		}


		for(Player pls : Bukkit.getOnlinePlayers()){
			if(Lists.get().Join.contains(pls.getName())){
				Chat.sendRaw(pls, "&8&l<&e&l-&8&l> &r&7" + e.getPlayer().getName());
		}
	}

}
}
