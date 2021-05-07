package AnimalKingdom;

import java.awt.*;
import java.util.Random;

public class Tiger extends Critter{
    private int numOfMoves;
    Random random=new Random();

    public int getNumOfMoves() {
        return numOfMoves;
    }

    public void setNumOfMoves(int numOfMoves) {
        this.numOfMoves = numOfMoves;
    }

    public Tiger(){

    }

    @Override
    public Color getColor() {
        //every 3 moves pick random color and return it
        if(getNumOfMoves()%3==0){
           int rand=random.nextInt(3) ;
           if (rand==1){
               return Color.RED;
           }else if(rand==2){
               return Color.GREEN;
           }else{
               return Color.BLUE;
           }
        }
        return super.getColor();
    }
    public Action getMove(CritterInfo info){
        numOfMoves++;
        if (info.getFront()==Neighbor.OTHER){
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
    public String toString() {
        //always return TGR
        return "TGR";
    }
}
