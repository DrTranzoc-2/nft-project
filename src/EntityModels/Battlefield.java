package EntityModels;

import EntityModels.EBot.Model.Bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Battlefield {

    public int id;
    private List<Battlefield> nexts,previous;
    private BattlefieldState state;
    private Faction faction;

    private List<Duel> duels;
    private List<Bot> armies;

    public Battlefield(int id){
        this.id = id;
        duels = new ArrayList<Duel>();
        armies = new ArrayList<>();
        state = BattlefieldState.NEUTRAL;

        nexts = new ArrayList<>();
        previous = new ArrayList<>();

        faction = null;
    }
    public boolean addSoldier(Bot soldier){
        return armies.add(soldier);
    }

    public boolean removeSoldier(Bot soldier){
        return armies.remove(soldier);
    }

    public void addPrevious(List<Battlefield> battlefield) { previous.addAll(battlefield); }

    public void addNexts(List<Battlefield> battlefield) { nexts.addAll(battlefield); }

    public List<Battlefield> getNexts(){
        return this.nexts;
    }

    public List<Battlefield> getPrevious() { return  this.previous; }

    public Faction getFaction() {return this.faction; }

    public BattlefieldState getState() {
        return state;
    }

    public void setFaction(Faction faction) { this.faction = faction; }


    @Override
    public String toString(){
        return "ID: " + this.id + "\n" +
                "FACTION: " + this.faction + "\n" +
                "NEXT: " + nexts.stream().map(x -> x.id).collect(Collectors.toList()) + "\n" +
                "PREV:" + previous.stream().map(x -> x.id).collect(Collectors.toList()) + "\n";
    }
}
