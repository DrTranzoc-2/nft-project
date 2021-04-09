package EntityModels;

import java.util.ArrayList;
import java.util.List;

public class ERA {

    private List<War> wars;

    public ERA(){
        wars = new ArrayList<War>();
    }

    public void addWar(War war){

        wars.add(war);

    }


}
