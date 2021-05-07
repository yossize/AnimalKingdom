package AnimalKingdom;

public class Giant extends Critter{
    int numOfMoves,countOfMoves;

    public Giant(){}
    public String toString(){
       // "fee" for 6 moves, then "fie" for 6 moves,
        // then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
        if (numOfMoves<24){
            countOfMoves=numOfMoves;
        }else{
            countOfMoves=numOfMoves-24;
        }
        if (countOfMoves<7){
            return "fee";
        }else if(countOfMoves<13){
            return "fie";
        }else if(countOfMoves<19){
            return "foe";
        }else{
            return "fum";
        }

    }
    public Action getMove(CritterInfo info){
        //always infect if an enemy is in front, otherwise hop if possible,
        // otherwise turn right.
        if (info.getFront()== Neighbor.OTHER){
            return Action.INFECT;
        }else if(info.getFront()==Neighbor.EMPTY){
            return Action.HOP;
        }else{
            return Action.LEFT;
        }
    }
}
