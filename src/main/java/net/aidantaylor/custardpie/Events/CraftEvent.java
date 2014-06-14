package net.aidantaylor.custardpie.events;

import net.aidantaylor.custardpie.utils.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftEvent implements Listener {
	@EventHandler
	public void onCraft(CraftItemEvent event) {
		if (event.getRecipe().getResult().isSimilar(Items.custardPie)) {
			if (!(event.getWhoClicked() instanceof Player)) {
				return;
			}
			
			Player p = (Player) event.getWhoClicked();
			
			if (!p.hasPermission("custardpie.create")) {
				event.setCurrentItem(new ItemStack(Material.AIR));
				event.setCancelled(true);
				
				p.closeInventory();
				p.sendMessage(ChatColor.RED + "You do not have permission to craft custard pies!");
			}
		}
	}
}
