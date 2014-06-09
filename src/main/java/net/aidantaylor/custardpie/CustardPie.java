package net.aidantaylor.custardpie;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustardPie extends JavaPlugin implements Listener {
	private boolean debug = true;

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);

		log(getName() + " has been enabled!", true);
		setPie();
	}

	@Override
	public void onDisable() {
		log(getName() + " has been disabled!", true);
		Bukkit.clearRecipes();
	}
	
	public void log(String string) {
		log(string, false);
	}
	
	public void log(String string, boolean bypassdebug) {
		if (bypassdebug == true || debug == true) {
			getLogger().info(string);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void setPie() {
		ItemStack custardPie = new ItemStack(Material.PUMPKIN_PIE, 1);
		ItemMeta pieMeta = custardPie.getItemMeta();
		pieMeta.setDisplayName(ChatColor.YELLOW + "Custard Pie");
		pieMeta.setLore(Arrays.asList(ChatColor.GOLD + "Throw Me!"));
		custardPie.setItemMeta(pieMeta);
		
		ShapelessRecipe pieRecipe = new ShapelessRecipe(custardPie);
		pieRecipe.addIngredient(Material.MILK_BUCKET);
		pieRecipe.addIngredient(Material.INK_SACK, DyeColor.YELLOW.getData());
		pieRecipe.addIngredient(Material.PUMPKIN_PIE);
		getServer().addRecipe(pieRecipe);
	}
}
