package EntityModels;

public enum WeaponStatTypes {

    BASE_DAMAGE( 0.05 , 0.8),
    RANGE( 1 , 30),
    ATK_SPEED( 0.2 , 0.8),
    SPREAD( 0.01 , 0.05),
    WEIGHT( 1,10),

    ELK_DAMAGE(0.01,0.1),
    CHM_DAMAGE(0.01,0.1),
    FIRE_DAMAGE(0.01,0.1),
    RAD_DAMAGE(0.01,0.1),
    BLEEDING(0.01,0.1);

    public final double min,max;

    private WeaponStatTypes(double min,double max){

        this.min = min;
        this.max = max;

    }

}
