package net.aidantaylor.custardpie.utils;

import java.util.ArrayList;

import net.aidantaylor.custardpie.Main;
import net.aidantaylor.custardpie.particles.ParticleEffect;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class PieUtils {
	public static ArrayList<Entity> pies = new ArrayList<Entity>();

	public static void throwCustardPie(Player player) {
		final Snowball s = player.launchProjectile(Snowball.class);
		for (Entity e : player.getNearbyEntities(5, 5, 5)) {
			if (e instanceof Player) {
				Player tPlayer = (Player) e;
				tPlayer.playSound(tPlayer.getLocation(), Sound.BAT_TAKEOFF, 2, 5);
			}
		}

		player.playSound(player.getLocation(), Sound.BAT_TAKEOFF, 2, 5);

		new BukkitRunnable() {
			@Override
			public void run() {
				Location l = s.getLocation();

				if (s.isDead()) {
					this.cancel();
					return;
				}

				ParticleEffect.CRIT.display(l, 0, 0, 0, (float) 0.3, 3);
				ParticleEffect.displayBlockDust(l, 35, (byte) 1, 0, 0, 0, (float) 0.05, 3);

				final Entity pie = l.getWorld().dropItem(l, new ItemStack(Material.INK_SACK, 1, (short) 11));
				pies.add(pie);

				new BukkitRunnable() {
					public void run() {
						pies.remove(pie);
						pie.remove();
					}
				}.runTaskLater(Main.instance, 4L);
			}
		}.runTaskTimer(Main.instance, 0L, 0L);

		player.sendMessage(ChatColor.AQUA + "You just threw a custard pie!");
	}
}