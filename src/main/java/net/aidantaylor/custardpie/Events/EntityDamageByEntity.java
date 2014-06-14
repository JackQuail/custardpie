package net.aidantaylor.custardpie.Events;

import net.aidantaylor.custardpie.Utils.Chat;
import net.aidantaylor.custardpie.Utils.Utils;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityDamageByEntity implements Listener {
	
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
		if(!(event.getEntity() instanceof Player && event.getDamager() instanceof Snowball)) return;

		Player hit = (Player) event.getEntity();
		Snowball snowball = (Snowball) event.getDamager();

		if(!(snowball.getShooter() instanceof Player)) return;

		Player damager = (Player) snowball.getShooter();
		
		Chat.sendMessage(hit, "&9&l" + damager.getName() + " &bjust pied you!");
		Chat.sendMessage(damager, "&bYou pied &9&l" + hit.getName() + "!");
		
		hit.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 3));

		for(Entity e : hit.getNearbyEntities(5, 5, 5)){
			if(!(e instanceof Player )) continue;
			Player tPlayer = (Player) e;
			tPlayer.playSound(tPlayer.getLocation(), Sound.FIREWORK_BLAST, 5, 2);
		}

		hit.playSound(hit.getLocation(), Sound.FIREWORK_BLAST, 5, 2);
		
		event.setDamage(0);
	}
}
