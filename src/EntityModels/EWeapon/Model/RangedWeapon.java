package EntityModels.EWeapon.Model;

import EntityModels.Rarity;

public class RangedWeapon extends Weapon{
    public RangedWeapon(String ID, String name, Rarity rarity, WeaponStats stats, String type) {
        super(ID, name, rarity, stats, type);
    }
}
