package EntityModels;

import EntityModels.EBot.Enum.BotState;
import EntityModels.EBot.Model.Bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameMap {

    private List<Battlefield> battlefields;
    private Battlefield spawnA, spawnB;

    public GameMap(List<Battlefield> battlefields){
        this.battlefields = battlefields;
        spawnA = battlefields.get(0);
        spawnB = battlefields.get(5);
    }

    public Battlefield spawnBot(Bot b){
        if(b.getFaction().name().equalsIgnoreCase("A")) {
            spawnA.addSoldier(b);
            return spawnA;
        }
        spawnB.addSoldier(b);
        return spawnB;
    }

    public List<Battlefield> getBattlefields() {
        return this.battlefields;
    }

    public static GameMap generateMap(int maxTerritorio){

        List<Battlefield> battlefields = new ArrayList<>();
        String mapString = "0:1,10,9|-1; 1:2|0; 2:3|1; 3:4|2,11; 4:5|3,11; 5:4,12,6|-1; 6:7|5; 7:8|6; 8:9|7,11; 9:0|8,11; 10:11|0; 11:3,4,8,9|10,12; 12:11|5";
        for(int i = 0; i < maxTerritorio; i++){
            battlefields.add(new Battlefield(i));
            battlefields.get(i).setFaction(Faction.A);
        }

        battlefields.get(0).setFaction(Faction.A);
        battlefields.get(5).setFaction(Faction.B);

        List<String> nodes = Arrays.asList(mapString.split(";"));
        for (String node: nodes) {
            int nodeId = Integer.parseInt(node.trim().split(":")[0]);
            String batts = node.trim().split(":")[1];
            List<Integer> succ = Arrays.asList(batts.split("\\|")[0].split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
            List<Integer> prev = Arrays.asList(batts.split("\\|")[1].split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());

            if(prev.get(0) != -1) {
                battlefields.get(nodeId).addPrevious(prev.stream().filter(x -> x != -1).map(x -> battlefields.get(x)).collect(Collectors.toList()));
            }

            battlefields.get(nodeId).addNexts(succ.stream().map(x -> battlefields.get(x)).collect(Collectors.toList()));
        }
        GameMap gameMap = new GameMap(battlefields);

        return gameMap;
    }

    public List<Battlefield> getPath(Bot bot, Battlefield target){
        return recursivePath(bot, bot.getCurrentPosition(), new ArrayList<Battlefield>(), target, false);
    }
    //TODO: Modificare
    public List<Battlefield> recursivePath(Bot bot, Battlefield currentPos, List<Battlefield> path, Battlefield target, boolean b){
        List<Battlefield> foundedPath = new ArrayList<>();
        if (target.getFaction() != null && !currentPos.getFaction().equals(bot.getFaction()) && !target.getState().equals(BattlefieldState.DISPUTED))
            return null;

        if(currentPos.id == target.id)
            return path;

        for(Battlefield next: currentPos.getNexts()) {
            if(path.stream().anyMatch(x->x.id == next.id))
                continue;

            if(next.id == 11 && bot.getBotState() != BotState.BATTLING_CENTER)
                continue;
            if(next.id != 0 && !b)
                continue;
            path.add(next);
            foundedPath = recursivePath(bot, next, path, target, b);
            if (foundedPath == null)
                path.remove(path.size() - 1);
            else return foundedPath;
        }

        for(Battlefield prev: currentPos.getPrevious()) {
            b = true;
            if(path.stream().anyMatch(x->x.id == prev.id))
                continue;
            if(prev.id == 11 && bot.getBotState() != BotState.BATTLING_CENTER)
                continue;
            path.add(prev);
            foundedPath = recursivePath(bot, prev, path, target,b);
            if (foundedPath == null)
                path.remove(path.size() - 1);
            else return foundedPath;
        }

        return foundedPath;
    }
}