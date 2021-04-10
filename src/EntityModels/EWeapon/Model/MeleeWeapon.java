package EntityModels.EWeapon.Model;

import EntityModels.Rarity;

public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String ID, String name, Rarity rarity, WeaponStats stats, String type) {
        super(ID, name, rarity, stats, type);
    }
}
