package club.infinitymage.deathswap.util;

import org.bukkit.ChatColor;

public class Util {

    public static String format(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static boolean isInt(String s)
    {
        try
        { int i = Integer.parseInt(s); return true; }

        catch(NumberFormatException er)
        { return false; }
    }

}
