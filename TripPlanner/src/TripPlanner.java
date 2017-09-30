import java.util.Scanner;

public class TripPlanner {

    public static void main(String[] args) {
        //greetingYou();
        //travelDetails();
        //timeDetails();
        areaCalc();
    }

    public static void greetingYou() {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input1.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destination = input2.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip.");
    }

    public static void travelDetails() {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input4 = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        Integer travelDays = input1.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        Double moneySpent = input2.nextDouble();
        System.out.print("What is the letter currency symbol for your travel destination? ");
        String currencySymbol = input3.next();
        System.out.print("How many " + currencySymbol + " are there in 1 USD? ");
        Double conversionRate = input4.nextDouble();
        System.out.println();

        System.out.println("If you are travelling for " + travelDays + ", that is the same as " + travelDays * 24 + " hours or " + travelDays * 1440 + " minutes.");
        System.out.println("If you are going to spend $" + moneySpent.intValue() + ", that means you can spend up to " + moneySpent / travelDays + " USD per day.");
        Double convertedMoney = conversionRate * moneySpent;
        System.out.println("Your total budget in " + currencySymbol + " is " + convertedMoney + ", which is " + convertedMoney / travelDays + " per day.");
    }

    public static void timeDetails() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        Integer timeDif = input1.nextInt();
        Integer currentTime = (timeDif) % 24;
        Integer newTime = (currentTime + 12) % 24;
        if (currentTime<0) currentTime += 24;
        System.out.println("That means that when it is midnight at home it will be " + currentTime + ":00 in your travel destination, and when it is noon at home it will be " + newTime + ":00.");
    }

    public static void areaCalc() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("What is the area of your destination in kilometres squared? ");
        Double areaKM = input1.nextDouble();
        System.out.println("In miles squared that is " + areaKM*0.386102 + ".");
    }
}