package EntityModels.EWeapon.Model;

import EntityModels.Rarity;

public abstract class Weapon {
    private String ID;
    private String name;
    private Rarity rarity;
    private WeaponStats stats;
    private String type;


    public Weapon(String ID, String name,Rarity rarity, WeaponStats stats, String type) {
        this.ID = ID;
        this.name = name;
        this.rarity = rarity;
        this.stats = stats;
        this.type = type;
    }

    public WeaponStats getWeaponStats()
    {
        return this.stats;
    }
    public String getType() { return this.type; }
    public Rarity getRarity() { return this.rarity; }
}
