import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class NinjaCat extends Critter {

    private ArrayList<Color> color = new ArrayList<Color>();
    private Random initial;
    private Color colors;


    public NinjaCat() {
        this.initial = new Random();
        color.add(Color.RED);
        color.add(Color.GREEN);
        color.add(Color.CYAN);
        color.add(Color.MAGENTA);
        color.add(Color.ORANGE);
        color.add(Color.PINK);
        color.add(Color.YELLOW);
        this.colors = color.get(initial.nextInt(7));
    }

    @Override
    public Color getColor() {
        Random coloring = new Random();
        colors = color.get(coloring.nextInt(7));
        return colors;
    }

    @Override
    public String toString() {
        return "=^.^=";
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.WALL){
            return Action.RIGHT;
        } else if (info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else {
            return Action.HOP;
        }
    }
}