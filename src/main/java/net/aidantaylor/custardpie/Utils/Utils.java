package net.aidantaylor.custardpie.Utils;

import net.aidantaylor.custardpie.Main;
import net.aidantaylor.custardpie.Particles.ParticleEffect;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by CaLxCyMru on 10/06/2014.
 */
public class Utils {


	public static void throwCustardPie(Player player){
		final Snowball s = player.launchProjectile(Snowball.class);
		for(Entity e : player.getNearbyEntities(5, 5, 5)){
			if(!(e instanceof Player )) continue;
			Player tPlayer = (Player) e;
			tPlayer.playSound(tPlayer.getLocation(), Sound.BAT_TAKEOFF, 2, 5);
		}
		
		player.playSound(player.getLocation(), Sound.BAT_TAKEOFF, 2, 5);
		new BukkitRunnable(){
			@Override
			public void run() {
				Location l = s.getLocation();
				if(s.isDead()){
					this.cancel();
					return;
				}
				
				ParticleEffect.CRIT.display(l, 0, 0, 0, (float) 0.3, 3);
				ParticleEffect.displayBlockDust(l, 35, (byte) 1, 0, 0, 0, (float) 0.05, 3);
				
				final Entity d = l.getWorld().dropItem(l, new ItemStack(Material.INK_SACK,1,(short) 11));
				new BukkitRunnable(){
					public void run(){
						d.remove();
					}
				}.runTaskLater(Main.instance, 4L);
			}
		}.runTaskTimer(Main.instance,0L,0L);

		sendMessage(player,"&bYou just threw a custard pie!");
	}

	public static void sendMessage(Player player, String message){
		player.sendMessage(message.replaceAll("&","�"));
	}


}
