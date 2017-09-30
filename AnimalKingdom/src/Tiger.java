import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Tiger extends Critter {

    private int numberOfMoves;
    private ArrayList<Color> colorPicker = new ArrayList<>();
    private Random initial;
    private Color colors;


    public Tiger() {
        this.initial = new Random();
        this.numberOfMoves = 0;
        colorPicker.add(Color.RED);
        colorPicker.add(Color.GREEN);
        colorPicker.add(Color.BLUE);
        this.colors = colorPicker.get(initial.nextInt(3));
    }

    @Override
    public Color getColor() {
        Random coloring = new Random();
        if (numberOfMoves%3 == 1) {
            colors = colorPicker.get(coloring.nextInt(3));
            return colors;
        } else {
            return colors;
        }
    }

    @Override
    public String toString() {
        return "TGR";
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            numberOfMoves += 1;
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            numberOfMoves += 1;
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME){
            numberOfMoves += 1;
            return Action.RIGHT;
        } else {
            numberOfMoves += 1;
            return Action.HOP;
        }
    }
}