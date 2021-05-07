package AnimalKingdom;

import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int numOfMoves;

    public Bear(){}
public Bear(boolean polar){
    this.polar=polar;
   // getColor();
}

    public boolean isPolar() {
        return polar;
    }

    public void setPolar(boolean polar) {
        this.polar = polar;
    }

    @Override
    public Action getMove(CritterInfo info) {
    //INFECT if enemy is found in front of you, else HOP if nothing if in front
        //else turn left
        if(info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        }else if(info.getFront()==Neighbor.EMPTY){
            return Action.HOP;
        }else
            return super.getMove(info);
    }

    @Override
    public Color getColor() {
    //return WHITE color if the bear is Polar, else return BLACK color
        if(this.polar==true){
            return Color.WHITE;
        }else{
            return Color.BLACK;
        }

    }

    @Override
    public String toString() {
    //switch between slash and backslash
        if(numOfMoves%2==0){
            return "/";
        }else
        {
            return "\\";
        }
    }


}
