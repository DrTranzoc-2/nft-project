package EntityModels;

import java.util.ArrayList;
import java.util.List;

public class WorldEvent {

    private EventType eventType;
    public static List<War> wars = new ArrayList<>();

    public WorldEvent(EventType eType){
        this.eventType = eType;
    }

    public static void addWar(War war) { wars.add(war); }

}
