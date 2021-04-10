package EntityModels;

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

    public Bot(String botID, Faction faction, BotStats stats, Rarity rarity, String botName) {
        this.botID = botID;
        this.faction = faction;
        this.stats = stats;
        this.rarity = rarity;
        this.botName = botName;

        health = 100;
        timer = 0;
        state = null;
    }

    public Weapon getBotWeapon() {
        return botWeapon;
    }

    public void setBotWeapon(Weapon botWeapon) {
        this.botWeapon = botWeapon;
    }
}
