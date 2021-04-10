package EntityControllers;

import EntityModels.*;
import EntityModels.EWeapon.Enum.MeleeModifiers;
import EntityModels.EWeapon.Enum.RangedModifiers;
import EntityModels.EWeapon.Model.*;
import EntityModels.EWeapon.Interfaces.WeaponModifierStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Spawner {
    private String currentSeed;

    public static Bot createBot(String botID, Faction faction){

        String botName = "bot"+botID;

        //Common : 60% Uncommon 20% rare 10% Epic 7% Legendary 3%

        Rarity rarity = getRarity();

        HashMap<BotStatTypes,Double> stats = new HashMap<>();
        for (BotStatTypes st:BotStatTypes.values()) {

            stats.put(st, Double.valueOf( ((Math.random() * (st.max - st.min)) + st.min) + rarity.bonus / 100));

        }

        return new Bot(""+botID,faction, new BotStats(stats), rarity, botName);
    }

    public static Weapon createWeapon(String weaponID, double era){
        if(era > 3 || era < 1)
            return null;

        String type = getWeaponType();
        String weaponName = "weapon"+weaponID;

        //Common : 60% Uncommon 20% rare 10% Epic 7% Legendary 3%
        Rarity rarity= getRarity();

        WeaponModifierStats weaponModifierStats = null;

        if(type.equalsIgnoreCase("ranged")) {
            RangedModifiers[] values =  RangedModifiers.values();
            do {
                weaponModifierStats = values[(int) (Math.random() * (values.length - 1))];
            }while(weaponModifierStats.getStats().get("ERA").get(1) < era);
          }
        else {
            MeleeModifiers[] values = MeleeModifiers.values();
            do {
                weaponModifierStats = values[(int) (Math.random() * (values.length - 1))];
            }while(weaponModifierStats.getStats().get("ERA").get(1) < era);
        }

        HashMap<String, Double> stats = new HashMap<>();
        for(String s: weaponModifierStats.getStats().keySet()){
            if(s.equalsIgnoreCase("ERA"))
                continue;
            double min = weaponModifierStats.getStats().get(s).get(0);
            double max = weaponModifierStats.getStats().get(s).get(1);
            double value = Double.valueOf( ((Math.random() * (max - min)) + min));
            value += (value * rarity.bonus)/100;
            stats.put(s, value);
        }

        WeaponStats weaponStats = new WeaponStats(stats, (int) era);
        if(type.equalsIgnoreCase("ranged"))
            return new RangedWeapon(weaponID, weaponName, rarity, weaponStats,type.toUpperCase());

        return new MeleeWeapon(weaponID, weaponName, rarity, weaponStats,type.toUpperCase());
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

    private static String getWeaponType(){
        return (Math.random() <= 0.5) ? "melee" : "ranged";
    }

    public static List<Bot> getBots(int nBots, Faction userFaction){

        List<Bot> bots = new ArrayList<Bot>();

        for(int i=0;i < nBots;i++){
            bots.add(createBot(""+i,userFaction));
        }
        return bots;
    }
}
