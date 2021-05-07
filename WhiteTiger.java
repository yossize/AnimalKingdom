package AnimalKingdom;

import java.awt.*;

public class WhiteTiger extends Critter{
    private boolean hasInfected=false;
    private int numOfMoves;

    public boolean isHasInfected() {
        return hasInfected;
    }

    public void setHasInfected(boolean hasInfected) {
        this.hasInfected = hasInfected;
    }

    public int getNumOfMoves() {
        return numOfMoves;
    }

    public void setNumOfMoves(int numOfMoves) {
        this.numOfMoves = numOfMoves;
    }

    public WhiteTiger(){}

    @Override
    public Action getMove(CritterInfo info) {
        numOfMoves++;
        if (info.getFront()==Neighbor.OTHER){
            hasInfected=true;
            return Action.INFECT;
        }else if(info.getFront()==Neighbor.WALL||info.getRight()==Neighbor.WALL){
            return Action.LEFT;
        }else if(info.getFront()==Neighbor.SAME){
            return Action.RIGHT;
        }else{
            return Action.HOP;
        }
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public String toString() {
        if (this.hasInfected)
            return "TGR";
        else{
            return "tgr";
        }
    }
}
