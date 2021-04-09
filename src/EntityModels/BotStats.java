package EntityModels;

import java.util.HashMap;

public class BotStats {

    private HashMap<BotStatTypes,Double> stats;

    public BotStats(HashMap<BotStatTypes,Double> stats){
        this.stats = stats;
    }
}
