package EntityModels;

import java.util.HashMap;

public class WeaponStats {

    private HashMap<WeaponStatTypes,Double> stats;
    private int era;

    public WeaponStats(HashMap<WeaponStatTypes,Double> stats,int era) {
        this.stats = stats;
        this.era = era;
    }

}
