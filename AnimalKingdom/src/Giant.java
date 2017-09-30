import java.awt.*;
import java.util.ArrayList;

public class Giant extends Critter {

    private int numberOfMoves;
//    ArrayList<String> words = new ArrayList<String>();

    public Giant() {
        this.numberOfMoves = 0;
//        words.add("fee");
//        words.add("fie");
//        words.add("fo");
//        words.add("fum");
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String toString() {

        if (numberOfMoves < 6) {
            return "fee";
        } else if (numberOfMoves < 12) {
            return "fie";
        } else if (numberOfMoves < 18) {
            return "fo";
        } else if (numberOfMoves < 24) {
            return "fum";
        } else {
            numberOfMoves = 0;
            return "fee";
        }


    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            numberOfMoves += 1;
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            numberOfMoves += 1;
            return Action.HOP;
        } else {
            numberOfMoves += 1;
            return Action.RIGHT;
        }
    }
}