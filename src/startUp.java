import EntityControllers.Spawner;
import EntityModels.EWeapon.Model.Weapon;
import EntityModels.Rarity;

public class startUp {

    public static void main(String args[]){
        int count = 0;
        for(int i = 0; i < 10000; i++){
            Weapon weapon = Spawner.createWeapon("1",1);
            if (weapon.getRarity() == Rarity.LEGENDARY)
                count++;
        }
        System.out.println(count);
    }

}
