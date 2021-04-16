package EntityModels;

public class War {
    public GameMap warGameMap;
    private int era;

    public War(GameMap warGameMap, int era){
        this.warGameMap = warGameMap;
        this.era = era;
    }

    public int getEra(){
        return this.era;
    }
}
