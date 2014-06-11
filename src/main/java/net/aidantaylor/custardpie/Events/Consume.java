package net.aidantaylor.custardpie.Events;

import net.aidantaylor.custardpie.Utils.Items;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class Consume implements Listener {
	
	public void onConsume(PlayerItemConsumeEvent event){
		if(event.getItem().isSimilar(Items.custardPie)) {
			 event.setCancelled(true);
		}
	}

}
