package net.aidantaylor.custardpie.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	
	public static ItemStack custardPie = createItemStack(Material.PUMPKIN_PIE, 1, 0, "&eCustard Pie", "&6Throw me!");

	public static ItemStack createItemStack(Material mat, int amount, int damage, String name, String lore) {
		ItemStack itemStack = new ItemStack(mat, amount, (short) damage);

		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		List<String> list = new ArrayList<String>();
		
		if (lore.contains("\n")) {
			for (String next : lore.split("\n")) {
				list.add(ChatColor.translateAlternateColorCodes('&', next));
			}
			itemMeta.setLore(list);
		} else {
			itemMeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', lore)));
		}
		

		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
}
