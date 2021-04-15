package Projects;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;
import java.time.Duration;

public class TripPlanner {

    public static void main(String[] args) {

        Greetings();
        TravelTimeAndBudget();
        TimeDifference();
        CountryArea();
        CalculateDistance1();

    }

    public static void Greetings() {
        Scanner scan = new Scanner(System.in);
        String name = "", destination = "";
        System.out.println("Welcome to Vacation Planner");
        System.out.print("what is your name?");
        name = scan.next();
        System.out.print("Nice to meet you " + name + ", where are you traveling to ?");
        destination = scan.next();
        System.out.println("Great! " + destination + " sounds like a great trip");
        EndSection();
        scan.close();
    }

    public static void TravelTimeAndBudget() {
        Scanner scan = new Scanner(System.in);
        int daysInTravel = 0;
        double moenyToSpend = 0;
        String currency = "";
        double exchange = 0;
        System.out.print("How many days are you going to spend in their destination?");
        daysInTravel = scan.nextInt();
        System.out.print("How much moeny, in USD, are you planning to spend on your trip?");
        moenyToSpend = scan.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination?");
        currency = scan.next();
        System.out.print("How many " + currency + " are there in 1 USD?");
        exchange = scan.nextDouble();
        CalcAndPrintTimeAndBudget(daysInTravel, moenyToSpend, currency, exchange);
        EndSection();
        scan.close();
    }

    public static void CalcAndPrintTimeAndBudget(int days, double moeny, String currency, double exchange) {
        System.out.println("If you are travelling for " + days + " days that is the same as " + days * 24 + " or " + days * 24 * 60 + " mintues");
        System.out.println("If you are going to spend $" + moeny + " USD, that means per day you can spend up to $ " + moeny / days);
        System.out.println("Your total budget in " + currency + " is " + moeny * exchange + " " + currency + ", which per day is " + moeny * exchange / days + " " + currency);
    }

    public static void TimeDifference() {
        Scanner scan = new Scanner(System.in);
        int timeDifference = 0;
        System.out.println("What is the time difference,in hours, between your hoem and your destination?");
        timeDifference = scan.nextInt();
        int timeAtDestinationMidnight, timeAtDestinationNoon;
        if (timeDifference < 0) {
            timeAtDestinationMidnight = 24 + timeDifference;
            timeAtDestinationNoon = 12 + timeDifference;
        } else {
            timeAtDestinationMidnight = timeDifference;
            timeAtDestinationNoon = 12 + timeDifference;
        }

        System.out.println("That means that when it is midnight at home it will be " + timeAtDestinationMidnight + ":00 in your travel destination");
        System.out.println("and when it is noon at home it will be " + timeAtDestinationNoon + ":00 in your travel destination");
        EndSection();
        scan.close();
    }

    public static void CountryArea() {
        Scanner scan=new Scanner(System.in);
        int squareArea=0;
        System.out.print("what is the square area of your destination country in km2?");
        squareArea= scan.nextInt();
        System.out.println("in miles2 is is "+ Math.pow(Math.sqrt(squareArea)*0.621,2));
        EndSection();
        scan.close();
    }
    public static void  CalculateDistance1(){
        double distance=CalculateDistance();
        System.out.println(distance);
    }
    public static double  CalculateDistance(){
        Scanner scan=new Scanner(System.in);
        double homeLongitude=0;
        double homeLatitude=0;
        double destLongitude=0;
        double destLatitude=0;

        System.out.println("please enter home's longitude ");
        homeLongitude=scan.nextDouble();
        System.out.println("please enter home's latitude ");
        homeLatitude=scan.nextDouble();
        System.out.println("please enter destinatio's longitude ");
        destLongitude=scan.nextDouble();
        System.out.println("please enter destinatio's latitude ");
        destLatitude=scan.nextDouble();
        String unit="M";
        System.out.print("chose the distance units - \"M\" - miles,\"K\" - kilometers,\"N\" - Nautical Mile");
        unit=scan.next();
        double theta = homeLongitude - destLongitude;
        double dist = Math.sin(deg2rad(homeLatitude)) * Math.sin(deg2rad(destLatitude)) + Math.cos(deg2rad(homeLatitude)) * Math.cos(deg2rad(destLatitude)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }
        scan.close();
        return (dist);

    }
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
    public static void EndSection() {
        System.out.println("*******************");
        System.out.println(" ");
    }

}
