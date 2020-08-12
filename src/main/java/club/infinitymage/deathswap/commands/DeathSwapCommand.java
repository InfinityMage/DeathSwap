package club.infinitymage.deathswap.commands;

import club.infinitymage.deathswap.DeathSwap;
import club.infinitymage.deathswap.managers.SwapManager;
import club.infinitymage.deathswap.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DeathSwapCommand implements CommandExecutor {

    private DeathSwap plugin;

    public DeathSwapCommand(DeathSwap plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String cmdName = cmd.getName().toLowerCase();

        if(!cmdName.equals("deathswap")) return false;
        if(!sender.hasPermission("deathswap.admin")) return true;

        if (args.length < 2) {
            sender.sendMessage(Util.format("&cIncorrect usage! /deathswap {player} {player} [duration in minutes]"));
        } else {

            if (Bukkit.getPlayerExact(args[0]) != null && Bukkit.getPlayerExact(args[1]) != null) {

                if (args.length > 2 && Util.isInt(args[2])) {
                    SwapManager.addSwap(args[0], args[1], Integer.parseInt(args[2]) * 60);
                    sender.sendMessage(Util.format("&c" + args[0] + " &eand &c" + args[1] + "&e will swap places every &c" + args[2] + "&e minutes."));
                } else {
                    SwapManager.addSwap(args[0], args[1], 300);
                    sender.sendMessage(Util.format("&c" + args[0] + " &eand &c" + args[1] + "&e will swap places every &c5 &e minutes."));
                }

            } else {
                sender.sendMessage(Util.format("&cIncorrect usage! /deathswap {player} {player} [duration in minutes]"));
            }

        }

        return true;

    }

}
