package EntityModels;

public enum Rarity {

    COMMON(0),
    UNCOMMON(1),
    RARE(2),
    EPIC(4),
    LEGENDARY(6);

    public final int bonus;

    private Rarity(int bonus){
        this.bonus = bonus;
    }


}
