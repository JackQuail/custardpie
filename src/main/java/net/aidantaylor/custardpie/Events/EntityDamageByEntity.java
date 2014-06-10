package net.aidantaylor.custardpie.Events;

import net.aidantaylor.custardpie.Utils.Utils;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
		if(!(event.getEntity() instanceof Player && event.getDamager() instanceof Arrow)) return;
		
		Player hit = (Player) event.getEntity();
		Arrow arrow = (Arrow) event.getDamager();
		if(!(arrow.getShooter() instanceof Player)) return;
		Player damager = (Player) arrow.getShooter();
		
		Utils.sendMessage(hit, "&9&l" + damager.getName() + " &bjust pied you!");
		Utils.sendMessage(damager, "&bYou pied &9&l" + hit.getName() + "!");
		event.setCancelled(true);
		
	}

}
