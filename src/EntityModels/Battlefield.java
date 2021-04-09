package EntityModels;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {


    private List<Battlefield> nexts,previous;

    private List<Duel> duels;
    private List<Bot> armies;

    public Battlefield(){

        duels = new ArrayList<Duel>();
        armies = new ArrayList<>();
    }

    public boolean addSoldier(Bot soldier){
        return armies.add(soldier);
    }

    public boolean removeSoldier(Bot soldier){
        return armies.remove(soldier);
    }

}
