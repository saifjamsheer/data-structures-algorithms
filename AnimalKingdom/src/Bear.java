import java.awt.*;

public class Bear extends Critter {

    private boolean polarity;
    private int numberOfMoves;

    public Bear(boolean polar) {
        this.polarity = polar;
        this.numberOfMoves = 0;
    }

    @Override
    public Color getColor() {
        if (this.polarity) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    @Override
    public String toString() {
        if (numberOfMoves%2 == 0) {
            return "/";
        } else {
            return "\\";
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
            return Action.LEFT;
        }
    }
}