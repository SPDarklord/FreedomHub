package net.freedom.dev.Listeners;

import java.util.ArrayList;

import net.freedom.dev.Runnables.Items;
import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.Lists;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("unused")
public class PlayerJoin implements Listener{

	@EventHandler

	public void onJoin(PlayerJoinEvent e)
	{
		Player player = e.getPlayer();
		player.chat("/spawn");
		e.setJoinMessage(null);
		Items.items(player);

		for(Player clockplayer : DyeHidePlayers.players){
			clockplayer.hidePlayer(player);
		}

		for(Player pls : Bukkit.getOnlinePlayers()){
			if(Lists.get().Join.contains(pls.getName())){
				Chat.sendRaw(pls, "&8&l<&e&l+&8&l> &r&7" + player.getName());
			}
		}

			if (!e.getPlayer().hasPlayedBefore())
			{ 
			}else{
				Chat.sendMessage(player, "Welcome back to the Freedom! community Minecraft server.");
			}



	}
}
