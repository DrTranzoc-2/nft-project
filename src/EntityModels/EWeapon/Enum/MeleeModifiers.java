package EntityModels.EWeapon.Enum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import EntityModels.EWeapon.Interfaces.WeaponModifierStats;

public enum MeleeModifiers implements WeaponModifierStats {
    KATANA("BASE_DAMAGE", "0","1",
                  "ATK_SPEED", "0.1", "1",
                  "RANGE", "1", "3",
                  "WEIGHT", "1","10",
                  "BLEEDING","0.01","0.1",
                  "ERA", "1", "3");

    public final HashMap<String, List<Double>> mapStats;
    MeleeModifiers(String...stats)  {
        HashMap<String, List<Double>> mapStats = new HashMap<String, List<Double>>();
        for(int i = 0; i < stats.length-2; i+=3)
        {
            List<Double> range = new ArrayList<>();
            range.add(Double.valueOf(stats[i+1]));
            range.add(Double.valueOf(stats[i+2]));
            mapStats.put(stats[i], range);
        }
        this.mapStats = mapStats;
    }

    @Override
    public HashMap<String, List<Double>> getStats() {
        return this.mapStats;
    }
}
