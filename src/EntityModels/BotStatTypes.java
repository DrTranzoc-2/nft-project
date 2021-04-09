package EntityModels;

public enum BotStatTypes {


    ATK( 0.2 , 0.94),
    SPEED( 1 , 5),
    DEF( 0.2 , 0.94),
    HEIGHT( 1.3 , 2.2),
    WEIGHT( 40,120),

    INTELLIGENCE(0.2,0.94),
    FORTUNE(0.01,0.1),
    BRAVERY(0.2,0.9),
    ELUSION(0.01,0.05),
    MALUS_RES(0.01,0.1);

    public final double min,max;

    private BotStatTypes(double min,double max){

        this.min = min;
        this.max = max;

    }
}
