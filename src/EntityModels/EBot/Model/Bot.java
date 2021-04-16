package EntityModels.EBot.Model;

import EntityModels.*;
import EntityModels.EBot.Enum.BotState;
import EntityModels.EWeapon.Model.Weapon;

public class Bot {

    private String botID;
    private String botName;

    private Faction faction;
    private BotStats stats;
    private Rarity rarity;

    public int health;
    public float timer;
    public BotState state;
    private Weapon botWeapon;

    private Battlefield currentPosition;

    public Bot(String botID, Faction faction, BotStats stats, Rarity rarity, String botName) {
        this.botID = botID;
        this.faction = faction;
        this.stats = stats;
        this.rarity = rarity;
        this.botName = botName;

        health = 100;
        timer = 0;
        state = null;

        currentPosition = null;
    }

    public Weapon getBotWeapon() {
        return botWeapon;
    }

    public void setBotWeapon(Weapon botWeapon) {
        this.botWeapon = botWeapon;
    }

    public Faction getFaction(){
        return this.faction;
    }

    public boolean displacement(int era){
        if(currentPosition != null)
            return false;

        War war = WorldEvent.wars.stream().filter(x -> x.getEra() == era).findFirst().orElse(null);
        if(war == null)
            return false;

        this.currentPosition = war.warGameMap.spawnBot(this);
        return true;
    }

    public Battlefield getCurrentPosition() {return this.currentPosition;}

    public void setCurrentPosition(Battlefield battlefield) { this.currentPosition = battlefield; }

    public BotState getBotState(){ return this.state; }
}
