package Projects;

import java.util.Random;
import java.util.Scanner;

public class OddsAndEvens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String gameType=setGame(scan);
        playGame(scan,gameType);
        scan.close();
    }
    public static void playGame(Scanner scan,String playType){
        System.out.println("How many \"fingers\" do you put out?");
        int player=scan.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("the compute plays "+ computer+" \"fingers\"");
        EndSection();
        int sum=player+computer;
        System.out.println(player+" + "+ computer +" = "+sum);
        String playResult;
        if(sum%2==0){
            playResult="Evens";
        }else{
            playResult="Odds";
        }
        System.out.println(sum +" is ...."+playResult);
        if(playResult.equals("Evens")&&playType.equals("E")){
            System.out.println("That means you won");
        }else{
            System.out.println("that means the computer has won");
        }
        EndSection();

    }

        public static String setGame(Scanner scan) {
            System.out.println("Let's play a game called \"Odds and Evens\"");
            System.out.print("What is your name");
            String name = scan.nextLine();
            System.out.print("Hello " + name + " which do you chose? (O)dds or (E)vens?");
            String gameType = scan.nextLine();
            if (gameType.equals("O")) {
                System.out.println(name + " has picked Odds! the computer will be Evens");
            } else {
                System.out.println(name + " has picked Evens! the computer will be Odds");
            }
            return gameType;
        }
        public static void EndSection() {
            System.out.println(" ");
            System.out.println("-------------------------------------");
        }
}
