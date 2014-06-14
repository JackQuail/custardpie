package net.aidantaylor.custardpie;

import net.aidantaylor.custardpie.commands.PieCommand;
import net.aidantaylor.custardpie.events.Consume;
import net.aidantaylor.custardpie.events.EntityDamageByEntity;
import net.aidantaylor.custardpie.events.PlayerInteract;
import net.aidantaylor.custardpie.utils.Recipe;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

	public static Main instance;

	@Override
	public void onEnable() {
		/** Set the instance the plugin as this class */
		instance = this;

		/** Register Events */
		registerEvents();

		getCommand("custardpie").setExecutor(new PieCommand());
		
		/** Register recipes */
		Recipe r = new Recipe();
		Bukkit.addRecipe(r.pie());
	}

	@Override
	public void onDisable() {
		/** Clear Recipes */
		Bukkit.clearRecipes();
	}

	public void registerEvents() {
		/** Register Events */
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerInteract(), this);
		pm.registerEvents(new EntityDamageByEntity(), this);
		pm.registerEvents(new Consume(), this);
	}
}
