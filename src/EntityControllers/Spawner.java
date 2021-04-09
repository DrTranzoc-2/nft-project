package EntityControllers;

import EntityModels.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Spawner {


    private String currentSeed;

    public static Bot createBot(int botID, Faction faction){

        String botName = "bot"+botID;

        //Common : 60% Uncommon 20% rare 10% Epic 7% Legendary 3%

        Rarity rarity = getRarity();

        HashMap<BotStatTypes,Double> stats = new HashMap<>();
        for (BotStatTypes st:BotStatTypes.values()) {

            stats.put(st, Double.valueOf( ((Math.random() * (st.max - st.min)) + st.min) + rarity.bonus / 100));

        }

        return new Bot(""+botID,faction, new BotStats(stats), rarity, botName);
    }

    public static Weapon createWeapon(int weaponID, int era){

        String weaponName = "weapon"+weaponID;

        //Common : 60% Uncommon 20% rare 10% Epic 7% Legendary 3%

        Rarity rarity= getRarity();
        WeaponType type = getWeaponType();

        HashMap<WeaponStatTypes,Double> stats = new HashMap<>();

        for (WeaponStatTypes st:WeaponStatTypes.values()) {
            double min = st.min;
            double max = st.max;

            //Special Checks
            if(st.name() == "RANGE")
            {

                if(type.name() == "RANGED")
                    min = 8;
                if(type.name() == "BASE_DAMAGE")
                    max /= 1.6;

            }
            if(st.name() == "SPREAD" && type.name() == "MELEE"){
                min = 0;
                max = 0;
            }
            switch (era){
                case 1:{
                    if(type.name() == "ELK_DAMAGE" || type.name() == "RAD_DAMAGE" || type.name() == "CHM_DAMAGE"){
                        min = 0;
                        max = 0;
                    }
                }break;
                case 2:{
                    if(type.name() == "ELK_DAMAGE"){
                        min = 0;
                        max = 0;
                    }
                }break;
                case 3:{
                    if(type.name() == "BLEEDING"){
                        min = 0;
                        max = 0;
                    }
                }break;

            }

            stats.put(st, Double.valueOf( ((Math.random() * (st.max - st.min)) + st.min) + rarity.bonus / 100));
        }

        return new Weapon(""+weaponID, new WeaponStats(stats,era), type, rarity, weaponName);
    }

    private static Rarity getRarity(){

        double number = Math.random();

        Rarity rarity= Rarity.LEGENDARY;

        if(number <= 0.6) {
            rarity = Rarity.COMMON;
        }
        else if(number > 0.6 && number <= 0.8) {
            rarity = Rarity.UNCOMMON;
        }
        else if(number > 0.8 && number <= 0.9) {
            rarity = Rarity.RARE;
        }
        else if(number > 0.9 && number <= 0.97) {
            rarity = Rarity.EPIC;
        }
        return rarity;
    }

    private static WeaponType getWeaponType(){
        WeaponType type= WeaponType.MELEE;

        double number = Math.random();

        if(number <= 0.5) {
            type = WeaponType.RANGED;
        }
        return type;
    }

    public static List<Bot> getBots(int nBots, Faction userFaction){

        List<Bot> bots = new ArrayList<Bot>();

        for(int i=0;i < nBots;i++){
            bots.add(createBot(i,userFaction));
        }
        return bots;
    }

}
