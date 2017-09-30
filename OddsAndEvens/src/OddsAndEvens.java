import java.util.*;

public class OddsAndEvens {

    public static void main(String[] args) {
        System.out.println("Let's play a game called \"Odds and Evens\".");
        System.out.print("What is your name? ");
        Scanner input1 = new Scanner(System.in);
        String playerName = input1.nextLine();
        System.out.print("Hi " + playerName + ", do you want to choose (O)dds or (E)vens? ");
        Scanner input2 = new Scanner(System.in);
        String oddOrEven = input2.nextLine();
        while (!oddOrEven.equals("O") && !oddOrEven.equals("E")) {
            System.out.print("Please enter an \'O\' or an \'E\'. ");
            oddOrEven = input2.nextLine();
        }
        if (oddOrEven.equals("O")) {
            System.out.println(playerName + " has picked odds! The computer will be evens.");
        } else /*if (oddOrEven.equals("E"))*/ {
            System.out.println(playerName + " has picked evens! The computer will be odds.");
        }
        System.out.println("--------------------------");
        System.out.print("How many fingers would you like to play? ");
        Scanner input3 = new Scanner(System.in);
        int fingersPlayed = input3.nextInt();
        while (fingersPlayed > 5) {
            System.out.print("Please pick a number between 0 and 5. ");
            fingersPlayed = input3.nextInt();
        }
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer played " + computer + " fingers.");
        System.out.println("--------------------------");
        int sumFingers = computer + fingersPlayed;
        System.out.println(fingersPlayed + " + " + computer + " = " + sumFingers);
        if (sumFingers % 2 == 0) {
            System.out.println(sumFingers + " is even.");
            if (oddOrEven.equals("E")) {
                System.out.println("Congratulations " + playerName + ", you win!");
            } else {
                System.out.println("Tough luck, the computer wins this time.");
            }
        } else {
            System.out.println(sumFingers + " is odd.");
            if (oddOrEven.equals("O")) {
                System.out.println("Congratulations " + playerName + ", you win!");
            } else {
                System.out.println("Tough luck, the computer wins this time.");
            }
        }
        System.out.println("--------------------------");
    }

}