package net.aidantaylor.custardpie.Events;

import net.aidantaylor.custardpie.Utils.Items;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class Consume implements Listener {
	
	@SuppressWarnings("deprecation")
	public void onConsume(PlayerItemConsumeEvent event) {
		if(event.getPlayer().getItemInHand().isSimilar(Items.custardPie)) {
			 event.setCancelled(true);
			 event.getPlayer().setItemInHand(event.getPlayer().getItemInHand());
			 event.getPlayer().updateInventory();
		}
	}

}
