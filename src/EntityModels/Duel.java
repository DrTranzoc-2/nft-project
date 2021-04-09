package EntityModels;

import java.util.ArrayList;
import java.util.List;

public class Duel {

    private Bot bot1,bot2;
    private List<WorldEvent> events;
    private String winner = "Draw";
    private double distance;

    public Duel(Bot bot1, Bot bot2){
         this.bot1 = bot1;
         this.bot2 = bot2;
         events = new ArrayList<WorldEvent>();
    }

}
