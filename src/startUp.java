import EntityControllers.Spawner;
import EntityModels.*;
import EntityModels.EBot.Model.Bot;

import java.util.List;

public class startUp {

    public static void main(String args[]){

        GameMap gameMap = GameMap.generateMap(13);
        Bot b1 = Spawner.createBot("1",Faction.A);
        WorldEvent.addWar(new War(gameMap, 1));
        b1.setCurrentPosition(gameMap.getBattlefields().get(11));
        Battlefield target = gameMap.getBattlefields().get(8);
        List<Battlefield> p = gameMap.getPath(b1, target);
        System.out.println(p);
    }

}
