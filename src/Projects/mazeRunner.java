package Projects;

import java.util.Scanner;

public class mazeRunner {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Maze myMap = new Maze();
        intro(myMap);
        play1(myMap);
        end();
    }

    public static void play1(Maze map){
        System.out.println("inside play1");
        while (map.didIWin()==false) {
            String userMove = userMove();
            map.printMap();
            if(userMove.equals("R")){
                System.out.println("right");
                if (map.canIMoveRight()) {
                    System.out.println("can move right");
                    map.moveRight();
                } else{
                    System.out.println("Sorry, you’ve hit a wall on right.");
                }
            }
            if(userMove.equals("L")){
                System.out.println("left");

                if (map.canIMoveLeft() == true) {
                    System.out.println("can move left");
                    map.moveLeft();
                } else{
                    System.out.println("Sorry, you’ve hit a left wall .");
                }
            }
            if(userMove.equals("U")){
                System.out.println("up");
                if (map.canIMoveUp() == true) {
                    System.out.println("can move up");
                    map.moveUp();
                } else{
                    System.out.println("Sorry, you’ve hit a wall up.");
                }
            }
            if(userMove.equals("D")){
                System.out.println("inside down");
                if (map.canIMoveDown() == true) {
                    System.out.println("can move down");
                    map.moveDown();
                } else{
                    System.out.println("Sorry, you’ve hit a down wall.");
                }
            }
        }
    }

    public static void play(Maze map) {
        while (map.didIWin()==false) {
            map.printMap();
            String userMove = userMove();
            switch (userMove) {
                case "R":
                    System.out.println("inside R");
                    if (map.canIMoveRight() == true) {
                        map.moveRight();
                    } else{
                        System.out.println("Sorry, you’ve hit a wall.");
                    }
                    break;
                case "L":
                    System.out.println("inside L");
                    if (map.canIMoveLeft() == true) {
                        map.moveLeft();
                    } else {
                        System.out.println("Sorry, you’ve hit a wall.");
                    }
                    break;
                case "U":
                    System.out.println("inside U");
                    if (map.canIMoveUp() == true) {
                        map.moveUp();
                    } else {
                        System.out.println("Sorry, you’ve hit a wall.");
                    }
                    break;
                case "D":
                    System.out.println("inside D");
                    if (map.canIMoveDown() == true) {
                        map.moveDown();
                    } else {
                        System.out.println("Sorry, you’ve hit a wall.");
                    }
                    break;
            }
        }
        System.out.println("Congratulations, you made it out alive!");
    }

    public static String userMove() {
        String userMove = "";
        while (!(userMove.equals("R") ||
                userMove.equals("L") ||
                userMove.equals("U") ||
                userMove.equals("D"))) {
            System.out.println("Where would you like to move? (R, L, U, D)");
            userMove = scan.next();
        }
        return userMove;
    }

    public static void intro(Maze map) {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your curent posiotion");
        map.printMap();
    }

    public static void end() {
        scan.close();
    }

}