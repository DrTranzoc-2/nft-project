package EntityModels;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<Battlefield> battlefields;
    private Battlefield spawnA, spawnB;

    public Map(List<Battlefield> battlefields){
        this.battlefields = battlefields;
        spawnA = battlefields.get(0);
        spawnB = battlefields.get(1);
    }

}