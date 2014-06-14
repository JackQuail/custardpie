package net.aidantaylor.custardpie.events;

import net.aidantaylor.custardpie.utils.Items;
import net.aidantaylor.custardpie.utils.Utils;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPieInteract(PlayerInteractEvent event) {
		if (event.getItem() != null && event.getItem().getType() != Material.AIR && event.getItem().isSimilar(Items.custardPie)) {
			event.setCancelled(true);
			event.getPlayer().updateInventory();
	
			if (event.getAction() != Action.RIGHT_CLICK_AIR) {
				return;
			}
	
			Utils.throwCustardPie(event.getPlayer());
	
			if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
				ItemStack i = event.getItem();
		
				event.getPlayer().getInventory().setItemInHand(new ItemStack(Material.AIR));
		
				if (i.getAmount() >= 2) {
					i.setAmount(i.getAmount() - 1);
					event.getPlayer().getInventory().setItemInHand(i);
				}
			}
		}
	}
}
