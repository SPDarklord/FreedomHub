package net.freedom.dev.Listeners;

import java.util.ArrayList;
import java.util.HashSet;

import net.freedom.dev.Main;
import net.freedom.dev.Utils.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.DyeColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class DyeHidePlayers implements Listener{
	public static HashSet<Player> players = new HashSet<Player>();
    ArrayList<String> lore = new ArrayList<String>();
	@SuppressWarnings("deprecation")
	ItemStack Clock = new ItemStack(Material.INK_SACK, 1, DyeColor.getByData((byte) 10).getData());
	ItemMeta ClockMeta = Clock.getItemMeta();
	@SuppressWarnings("deprecation")
	ItemStack Clock2 = new ItemStack(Material.INK_SACK, 1, DyeColor.getByData((byte) 8).getData());
	ItemMeta Clock2Meta = Clock2.getItemMeta();
	String one = "" + ChatColor.GREEN + ChatColor.BOLD + "Right click to disable player visability";
	String two = "" + ChatColor.GREEN + ChatColor.BOLD + "Right click to enable player visability";
	final ArrayList<String> cooldown = new ArrayList<String>();

	 @SuppressWarnings({ "static-access" })
	@EventHandler
	 public void onPlayerInteract(PlayerInteractEvent e) {
		 
		 

		 org.bukkit.event.block.Action Action = e.getAction();
		 
		 if(Action == org.bukkit.event.block.Action.PHYSICAL || e.getItem() == null || e.getItem().getType() == Material.AIR){
			 return;
		 }
		 
		 if(e.getItem().getType() == Material.INK_SACK){
			final Player p = e.getPlayer();
			if(cooldown.contains(p.getName())){
				Chat.sendMessage(p, "You can only use this item every 3 seconds!");
				e.setCancelled(true);
				return;
			}else{
				
				if(players.contains(p)){
					//unhideplayers
					for(Player pls : Bukkit.getServer().getOnlinePlayers()){
					    e.getPlayer().showPlayer(pls);
					}
					this.players.remove(p);
					ClockMeta.setDisplayName( "" + ChatColor.GREEN + ChatColor.BOLD + "§ePlayer Visability ➠ §2Enabled");
					lore.clear();
					lore.add(one);
					ClockMeta.setLore(lore);
					Clock.setItemMeta(ClockMeta);
				    Chat.sendMessage(p, "You can now see other players!");
   					p.getInventory().setItem(4, Clock);
				}else{
					//hideplayers
					for(Player pls : Bukkit.getServer().getOnlinePlayers()){
						 if(!pls.hasPermission("hub.staff")) {
						   e.getPlayer().hidePlayer(pls);
						 }
					 }
					this.players.add(p);
					 Chat.sendMessage(p, "You can no longer see other players!");
					 Clock2Meta.setDisplayName( "" + ChatColor.GREEN + ChatColor.BOLD + "§ePlayer Visability ➠ §4Disabled");
					 lore.clear();
					 lore.add(two);
					 Clock2Meta.setLore(lore);
					 Clock2.setItemMeta(Clock2Meta);
					 p.getInventory().setItem(4, Clock2);
				}
				if(!(p.hasPermission("hub.staff"))){
				cooldown.add(p.getName());
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					@Override
					public void run() {
						cooldown.remove(p.getName());
					}
					
				}, 60L);
				return;
				}else{
					Chat.sendRaw(p, "");
					Chat.sendMessage(p, "You are an admin and did not have to have a delay <3");
					Chat.sendMessage(p, "You skipped the delay! Don't spam it!");
				}
			}
			
		 } 
		 
	 }
	
}
