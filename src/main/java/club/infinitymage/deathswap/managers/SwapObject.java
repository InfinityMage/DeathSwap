package club.infinitymage.deathswap.managers;

import club.infinitymage.deathswap.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.UUID;

public class SwapObject {

    public String player1;
    public String player2;
    public int duration;
    public int counter;

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public int getDuration() {
        return duration;
    }

    public void update() {
        Player p1 = Bukkit.getPlayerExact(this.player1);
        Player p2 = Bukkit.getPlayerExact(this.player2);

        if (p1 != null && p2 != null) {
            if (counter == 0) {
                swap();
                counter = duration;
            }
            if (counter < 11 && counter > 1) {
                p1.sendMessage(Util.format("&eSwapping in &c"+ counter +"&e seconds..."));
                p2.sendMessage(Util.format("&eSwapping in &c"+ counter +"&e seconds..."));
            } else if (counter == 1) {
                p1.sendMessage(Util.format("&eSwapping in &c1 &esecond..."));
                p2.sendMessage(Util.format("&eSwapping in &c1 &esecond..."));
            }

            counter--;
        }

    }

    public void swap() {
        Player p1 = Bukkit.getPlayer(this.player1);
        Player p2 = Bukkit.getPlayer(this.player2);

        if (p1 != null && p2 != null) {
            Location player1loc = p1.getLocation();
            Location player2loc = p2.getLocation();

            p1.teleport(player2loc, PlayerTeleportEvent.TeleportCause.PLUGIN);
            p2.teleport(player1loc, PlayerTeleportEvent.TeleportCause.PLUGIN);

            p1.sendMessage(Util.format("&c&lSwapped!"));
            p2.sendMessage(Util.format("&c&lSwapped!"));
        }

    }

    public SwapObject(String player1, String player2, int duration) {
        this.player1 = player1;
        this.player2 = player2;
        this.duration = duration;
        this.counter = duration;
    }

}