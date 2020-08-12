package club.infinitymage.deathswap.managers;

import java.util.ArrayList;

public class SwapManager {

    public static final ArrayList<SwapObject> swaps = new ArrayList<SwapObject>();

    public static void addSwap(String p1, String p2, int duration) {
        swaps.add(new SwapObject(p1, p2, duration));
    }

    public static void removeSwap(SwapObject s) {
        swaps.remove(s);
    }

    public static void updateAll() {

        for (int i = 0; i < swaps.size(); i++) {
            swaps.get(i).update();
        }

    }

}