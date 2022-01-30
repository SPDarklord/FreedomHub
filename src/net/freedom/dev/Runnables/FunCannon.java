package net.freedom.dev.Runnables;

import java.util.ArrayList;
import net.freedom.dev.Main;
import net.freedom.dev.Utils.Chat;
import net.freedom.dev.Utils.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

@SuppressWarnings("unused")
public class FunCannon
  implements Listener
{
  final ArrayList<String> cooldown = new ArrayList<String>();
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void cannon(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();
    if (((event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || (event.getAction().equals(Action.RIGHT_CLICK_AIR))) && (player.getItemInHand().getType() == Material.BLAZE_ROD))
    {
      player.throwSnowball();
    }
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void snowball(ProjectileHitEvent e)
  {
    Entity entity = e.getEntity();
    Projectile proj = (Projectile)entity;
    final Entity shooter = (Entity) proj.getShooter();
    if (this.cooldown.contains(((Player)shooter).getName()))
    {
      Chat.sendMessage((Player)shooter, "You can only use this item every 3 seconds!");
      ((Cancellable)e).setCancelled(true);
      return;
    }
    if (entity.getType() == EntityType.SNOWBALL)
    {
      Location loc = entity.getLocation();
      for (Player pls : Bukkit.getOnlinePlayers())
      {
        pls.playEffect(loc, Effect.ENDER_SIGNAL, 5);
        ParticleEffect.HEART.display(1.0F, 2.0F, 1.0F, 1.0F, 12, loc, 64.0D);
        ParticleEffect.CLOUD.display(0.0F, 1.0F, 0.0F, 1.0F, 64, loc, 32.0D);
        ParticleEffect.ENCHANTMENT_TABLE.display(1.0F, 2.0F, 1.0F, 1.0F, 180, loc, 64.0D);
        ParticleEffect.PORTAL.display(1.0F, 2.0F, 3.0F, 2.0F, 180, loc, 64.0D);
        pls.playSound(loc, Sound.BAT_DEATH, 1.0F, 1.0F);
      }
    }
  }
  }

