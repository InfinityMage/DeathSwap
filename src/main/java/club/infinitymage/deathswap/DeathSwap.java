package club.infinitymage.deathswap;

import club.infinitymage.deathswap.commands.DeathSwapCommand;
import club.infinitymage.deathswap.managers.SwapManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathSwap extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pm = Bukkit.getPluginManager();

        this.getCommand("deathswap").setExecutor(new DeathSwapCommand(this));

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                SwapManager.updateAll();
            }
        }, 0L, 20);

    }

}
