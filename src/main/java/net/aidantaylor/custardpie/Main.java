package net.aidantaylor.custardpie;

import net.aidantaylor.custardpie.Commands.PieCommand;
import net.aidantaylor.custardpie.Events.PlayerInteract;
import net.aidantaylor.custardpie.Utils.Recipe;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin{

    public static Main instance;

	@Override
	public void onEnable() {
        instance = this;

		getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
		getCommand("custardpie").setExecutor(new PieCommand());
        Recipe r = new Recipe(this);
        Bukkit.addRecipe(r.pie());
	}

	@Override
	public void onDisable() {
		Bukkit.clearRecipes();
	}
}
