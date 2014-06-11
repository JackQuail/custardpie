package net.aidantaylor.custardpie.Events;

import net.aidantaylor.custardpie.Utils.Utils;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityDamageByEntity implements Listener {
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
		if(!(event.getEntity() instanceof Player && event.getDamager() instanceof Snowball)) return;
		
		Player hit = (Player) event.getEntity();
		Snowball snowball = (Snowball) event.getDamager();
		
		if(!(snowball.getShooter() instanceof Player)) return;
		
		Player damager = (Player) snowball.getShooter();
		
		Utils.sendMessage(hit, "&9&l" + damager.getName() + " &bjust pied you!");
		Utils.sendMessage(damager, "&bYou pied &9&l" + hit.getName() + "!");
		
		hit.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 3));
		
		event.setCancelled(true);
		
	}

}
