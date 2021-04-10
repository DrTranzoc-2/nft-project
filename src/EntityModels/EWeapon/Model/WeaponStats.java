package EntityModels.EWeapon.Model;

import java.util.HashMap;

public class WeaponStats {

    private HashMap<String,Double> stats;
    private int era;

    public WeaponStats(HashMap<String,Double> stats,int era) {
        this.stats = stats;
        this.era = era;
    }

    public HashMap<String, Double> getStats()
    {
        return this.stats;
    }

}
