package net.aidantaylor.custardpie.Utils;

import net.aidantaylor.custardpie.Main;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;


/**
 * Created by CaLxCyMru on 10/06/2014.
 */
public class Recipe {

    public Recipe(Main plugin) {

    }

    @SuppressWarnings("deprecation")
	public ShapelessRecipe pie() {

        ItemStack custardPie = Items.custardPie;

        ShapelessRecipe pieRecipe = new ShapelessRecipe(custardPie);
        pieRecipe.addIngredient(Material.MILK_BUCKET);
        pieRecipe.addIngredient(Material.INK_SACK, 11);
        pieRecipe.addIngredient(Material.PUMPKIN_PIE);
        return pieRecipe;
    }


}

