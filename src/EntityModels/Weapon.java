package EntityModels;

public class Weapon {

    private String weaponID;
    private WeaponStats stats;
    private WeaponType weapType;
    private Rarity rarity;
    private String weaponName;

    public Weapon(String weaponID, WeaponStats stats, WeaponType weapType, Rarity rarity, String weaponName) {
        this.weaponID = weaponID;
        this.stats = stats;
        this.weapType = weapType;
        this.rarity = rarity;
        this.weaponName = weaponName;
    }
}
