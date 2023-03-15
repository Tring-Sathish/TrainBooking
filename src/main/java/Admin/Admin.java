package Admin;

import java.util.*;
import Trainbooking.*;
import User.*;

public class Admin {

    Scanner input = new Scanner(System.in);
    public ArrayList<Traindetails> traindetails = new ArrayList<>();
//    BookTrain bookTrain = new BookTrain();
    Float trainstartTime;
    Float trainendTime;
    int count = 0;
    int totalAmount;
    int totalCost;
    public int window;
    int windowAc = 22;
    int middle, middleAc = 22;
    int aisle, aisleAc = 22;
    int upper, upperAc = 12;
    int lower, lowerAc = 12;
    int middleSleeper, middleSleeperAc = 12;
    int sideUpper, sideUpperAc = 6;
    int sideLower, sideLowerAc = 6;

    public void signIn() {
        final String name = "train";
        final String pass = "123";

        System.out.print("\nEnter Your Name : ");
        String userName = input.next();
        System.out.print("\nEnter Your Password : ");
        String passWord = input.next();

        if (name.equals(userName) && pass.equals(passWord)) {
            System.out.print("\nSign In Succesfully\n");
            options();
        } else {
            System.out.print("\n\nUsername or Passward Mismatch\n\n");
            return;
        }
    }

    // Display options after admin signin
    void options() {
        while (true) {
            System.out.print(
                    "\n\n1. Add Train \n2. Food Menu \n3. Total Cost of Travel \n4. Log out \n\n Enter Your Choice : ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addTrain();
                    break;
                case 2:
                    foodMenu();
                    break;
                case 3:
                    totalCostAllTrain();
                    break;
                case 4:
                    Main.main(null);
                default:
                    System.out.print(" \n Invalid Choice ");
                    break;
            }
        }
    }

    // Add train details in arraylist

    void addTrain() {

        System.out.print(" \n\tAdd Train\n");
        System.out.print(" \nEnter Train Name : ");
        String trainName = input.next();

        System.out.print(" \nEnter Source Location : ");
        String sourceLocation = input.next();

        System.out.print(" \nEnter Destination Location : ");
        String destinationLocation = input.next();

        System.out.print(" \nEnter Start Time : ");
        Float startTime = input.nextFloat();

        System.out.print(" \nEnter End Time : ");
        Float endTime = input.nextFloat();

        System.out.print(" \nEnter Total Distance : ");
        int distance = input.nextInt();

        System.out.print("\nEnter the number of coaches to be Add : ");
        System.out.print("\nChaircar : ");
        int noofcoaches1 = input.nextInt();

        System.out.print("\nChaircar Ac : ");
        int noofcoaches2 = input.nextInt();

        System.out.print("\nSleeper Car : ");
        int noofcoaches3 = input.nextInt();

        System.out.print("\nSleeper Car Ac : ");
        int noofcoaches4 = input.nextInt();

        traindetails.add(new Traindetails(trainName, sourceLocation, destinationLocation, startTime, endTime, distance,
                noofcoaches1, noofcoaches2, noofcoaches3, noofcoaches4));
        totalCost();
    }

    // Adding total cost of train
    void totalCost() {
        int windowPrice = 2 * window * traindetails.get(count).chair * traindetails.get(count).distance;
        int aislePrice = 2 * aisle * traindetails.get(count).chair * traindetails.get(count).distance;
        int middlePrice = 1 * middle * traindetails.get(count).chair * traindetails.get(count).distance;
        int totalCostchair = windowPrice + aislePrice + middlePrice;

        int windowPriceAc = 6 * windowAc * traindetails.get(count).chairac * traindetails.get(count).distance;
        int aislePriceAc = 6 * aisleAc * traindetails.get(count).chairac * traindetails.get(count).distance;
        int middlePriceAc = 5 * middleAc * traindetails.get(count).chairac * traindetails.get(count).distance;
        int totalCostchairAc = windowPriceAc + aislePriceAc + middlePriceAc;

        int upperPrice = 1 * upper * traindetails.get(count).sleeper * traindetails.get(count).distance;
        int lowerPrice = 1 * lower * traindetails.get(count).sleeper * traindetails.get(count).distance;
        int middlesleeperPrice = 1 * middleSleeper * traindetails.get(count).sleeper * traindetails.get(count).distance;
        int sideUpperPrice = 1 * sideUpper * traindetails.get(count).sleeper * traindetails.get(count).distance;
        int sideLowerPrice = 1 * sideLower * traindetails.get(count).sleeper * traindetails.get(count).distance;
        int totalCostsleeper = upperPrice + lowerPrice + middlesleeperPrice + sideLowerPrice + sideUpperPrice;

        int upperPriceAc = 5 * upperAc * traindetails.get(count).sleeper * traindetails.get(count).distance;
        int lowerPriceAc = 5 * lowerAc * traindetails.get(count).sleeper * traindetails.get(count).distance;
        int middlesleeperPriceAc = 5 * middleSleeperAc * traindetails.get(count).sleeper
                * traindetails.get(count).distance;
        int sideUpperPriceAc = 5 * sideUpperAc * traindetails.get(count).sleeper * traindetails.get(count).distance;
        int sideLowerPriceAc = 5 * sideLowerAc * traindetails.get(count).sleeper * traindetails.get(count).distance;
        int totalCostsleeperAc = upperPriceAc + lowerPriceAc + middlesleeperPriceAc + sideLowerPriceAc
                + sideUpperPriceAc;

        totalCost = totalCostchair + totalCostchairAc + totalCostsleeper + totalCostsleeperAc;
        System.out.print("\nTotal Cost of " + traindetails.get(count).trainName + " = " + totalCost);
        totalAmount += totalCost;
        count++;
        System.out.print("\n___________________________________________________");
    }

    void totalCostAllTrain() {
        for (int i = 0; i < traindetails.size(); i++) {
            System.out.print("\nTotal Cost of train " + traindetails.get(i).trainName + " is = ");
        }
        System.out.print("\nTotal Cost : " + totalAmount);
    }

    public void browseTrains() {
        while (true) {
            System.out.print(
                    "\n\n1. Search train by Source Location \n2. Search train by Destination Location \n3. Exit\n");
            System.out.print("\nEnter your choice : ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    browseSourceLocation();
                    availableMenu();
                    break;

                case 2:
                    browseDestinationLocation();
                    availableMenu();
                    break;

                case 3:
                    return;

                default:
                    System.out.print("\nInvalid choice");
            }
        }
    }

    // Browse train by source location
    void browseSourceLocation() {
        System.out.print("\n\tBrowse Train\n");
        System.out.print("\nEnter train Source Location :");
        String sLocation = input.next();

        for (int i = 0; i < traindetails.size(); i++) {
            if (sLocation.equals(traindetails.get(i).sourceLocation)) {
                System.out.print(traindetails.get(i));

                trainstartTime = traindetails.get(i).startTime;
                trainendTime = traindetails.get(i).endTime;
//                bookTrain.bookTrain();
            } else {
                return;
            }
        }
    }

    // Browse train by destination location
    void browseDestinationLocation() {
        System.out.print("\n\tBrowse Train\n");
        System.out.print("\nEnter train Destination Location : ");
        String dLocation = input.next();

        for (int i = 0; i < traindetails.size(); i++) {
            if (dLocation.equals(traindetails.get(i).destinationLocation)) {
                System.out.print(traindetails.get(i));
                System.out.print(traindetails.get(i));
                trainstartTime = traindetails.get(i).startTime;
                trainendTime = traindetails.get(i).endTime;
//                bookTrain.bookTrain();
            } else {
                return;
            }

        }

    }

    ArrayList<Fooddetails> breakFast = new ArrayList<>();
    ArrayList<Fooddetails> lunch = new ArrayList<>();
    ArrayList<Fooddetails> dinner = new ArrayList<>();
//    Admin admin = new Admin();

    void foodMenu() {
        while (true) {
            System.out.print(" \n\n\t Food Menu\n");
            System.out.print(" 1. Breakfast \n 2. Lunch \n 3. Dinner \n 4. Display Menu\n 5. Exit\n");
            System.out.print("\nEnter your choice : ");
            int choice2 = input.nextInt();
            switch (choice2) {
                case 1:
                    breakFast();
                    break;
                case 2:
                    lunch();
                    break;
                case 3:
                    dinner();
                    break;
                case 4:
                    displayMenu();
                    break;
                case 5:
//                    admin.options();
                default:
                    System.out.print(" \n Invalid Choice\n ");
                    break;
            }
        }
    }

    // Add breakfast
    void breakFast() {
        System.out.print("\nEnter Your Breakfast : ");
        String Name = input.next();
        System.out.print("\nEnter the price for Breakfast : ");
        int Price = input.nextInt();
        float startTime = 7;
        float endTime = 10;
        System.out.print(
                "\nAvailable time : " + String.format("%.02f", startTime) + " - " + String.format("%.02f", endTime));
        breakFast.add(new Fooddetails(Name, Price, startTime, endTime));

    }

    // Add lunch
    void lunch() {
        System.out.print("\nEnter Your Lunch : ");
        String Name = input.next();
        System.out.print("\nEnter the price for Lunch : ");
        int Price = input.nextInt();
        float startTime = 13;
        float endTime = 15;
        System.out.print(
                "\nAvailable time : " + String.format("%.02f", startTime) + " - " + String.format("%.02f", endTime));
        lunch.add(new Fooddetails(Name, Price, startTime, endTime));

    }

    // Add dinner
    void dinner() {
        System.out.print("\nEnter Your Dinner : ");
        String Name = input.next();
        System.out.print("\nEnter the price for Dinner : ");
        int Price = input.nextInt();
        float startTime = 19;
        float endTime = 22;
        System.out.print(
                "\nAvailable time : " + String.format("%.02f", startTime) + " - " + String.format("%.02f", endTime));
        dinner.add(new Fooddetails(Name, Price, startTime, endTime));
    }

    // Display all the menu items
    void displayMenu() {
        System.out.print("\n\tBreakfast");
        for (int i = 0; i < breakFast.size(); i++) {
            System.out.print(breakFast.get(i));
        }

        System.out.print("\n\n\tLunch");
        for (int i = 0; i < lunch.size(); i++) {
            System.out.print(lunch.get(i));
        }

        System.out.print("\n\n\tDinner");
        for (int i = 0; i < dinner.size(); i++) {
            System.out.print(dinner.get(i));
        }
    }

    // Display menu if availble between train time
    void availableMenu() {

        for (int i = 0; i < breakFast.size(); i++) {
            if (trainstartTime <= breakFast.get(i).startTime && trainendTime >= breakFast.get(i).endTime) {
                System.out.print(breakFast.get(i));
            }
        }

        for (int i = 0; i < lunch.size(); i++) {
            if (trainstartTime <= lunch.get(i).startTime && trainendTime >= lunch.get(i).endTime) {
                System.out.print(lunch.get(i));
            }
        }

        for (int i = 0; i < dinner.size(); i++) {
            if (trainstartTime <= dinner.get(i).startTime && trainendTime >= dinner.get(i).endTime) {
                System.out.print(dinner.get(i));
            }
        }

    }

}