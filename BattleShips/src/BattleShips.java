import java.util.Scanner;
import java.util.Random;

public class BattleShips {

    int[][] ocean = new int[10][10];

    public static void main(String[] args) {

        System.out.println("Welcome to Battle Ships!\n");
        System.out.println("Right now, the sea is empty.\n");
        BattleShips call = new BattleShips();
        call.oceanMap();
        System.out.println();
        call.deployShips();
        call.computerShips();
        call.battle();

    }

    public void oceanMap() {

        //int[][] ocean = new int[10][10];

        System.out.println("   0123456789   ");

        for (int i = 0; i < ocean.length; i++) {
            System.out.print(i + " |");
            for (int n = 0; n < ocean[i].length; n++) {
                if (ocean[i][n] == 0 || ocean[i][n] == 2) {
                    System.out.print(" ");
                } else if (ocean[i][n] == 1) {
                    System.out.print("@");
                } else if (ocean[i][n] == 3) {
                    System.out.print("#");
                } else if (ocean[i][n] == 5) {
                    System.out.print("x");
                } else {
                    System.out.print("-");
                }
            }
            System.out.print("| " + i);
            System.out.println();
        }
        System.out.println("   0123456789   ");
    }

    public void deployShips() {

        System.out.println("Deploy your ships:");
        Scanner xInput = new Scanner(System.in);
        Scanner yInput = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter x coordinate for ship no. " + i + ": ");
            int x = xInput.nextInt();
            while (x > 9 || x < 0) {
                System.out.print("Please enter a valid x coordinate: ");
                x = xInput.nextInt();
            }
            System.out.print("Enter y coordinate for ship no. " + i + ": ");
            int y = yInput.nextInt();
            while (y > 9 || y < 0) {
                System.out.print("Please enter a valid y coordinate: ");
                y = yInput.nextInt();
            }
            if (ocean[x][y] == 1) {
                System.out.println("A ship already exists in that location. Please pick new coordinates.");
                i --;
            } else {
                ocean[x][y] = 1;
            }

        }
        System.out.println();
        oceanMap();
        System.out.println();
    }

    public void computerShips() {
        System.out.println("Computer is deploying ships.");
        Random xGenerator = new Random();
        Random yGenerator = new Random();
        for (int i = 1; i <= 5; i++) {
            int x = xGenerator.nextInt(10);
            int y = yGenerator.nextInt(10);

            if (ocean[x][y] == 1 || ocean[x][y] == 2){
                i --;
            } else {
                ocean[x][y] = 2;
                System.out.println("Ship no. " + i + " deployed.");
            }


        }
        System.out.println();
        oceanMap();
        System.out.println();
    }

    public void battle() {
        Scanner xGuess = new Scanner(System.in);
        Scanner yGuess = new Scanner(System.in);
        Random xGen = new Random();
        Random yGen = new Random();
        int totalComputer = 5;
        int totalPlayer = 5;

        while (totalComputer != 0 && totalPlayer != 0) {
            //Player Turn
            System.out.println("PLAYER'S TURN:");
            System.out.print("Enter x coordinates: ");
            int x1 = xGuess.nextInt();
            System.out.print("Enter y coordinates: ");
            int y1 = yGuess.nextInt();
            if (ocean[x1][y1] == 1) {
                System.out.println("You sunk your own ship. Fucking rookie.");
                ocean[x1][y1] = 3;
                totalPlayer --;
            } else if (ocean[x1][y1] == 2) {
                System.out.println("Our artillery destroyed their ship. Good work soldier.");
                ocean[x1][y1] = 5;
                totalComputer --;
            } else if (ocean[x1][y1] == 5 || ocean[x1][y1] == 3) {
                System.out.println("That ship's already at the bottom of the sea. Pay more attention next time rookie.");
            } else {
                System.out.println("Our recon failed us. Let's hope it doesn't happen again.");
                ocean[x1][y1] = 4;
            }
            System.out.println("COMPUTER'S TURN:");
            int x2 = xGen.nextInt(10);
            int y2 = yGen.nextInt(10);
            if (ocean[x2][y2] == 2) {
                System.out.println("The enemy sunk its own ship. Cowards.");
                ocean[x2][y2] = 5;
                totalComputer --;
            } else if (ocean[x2][y2] == 1) {
                System.out.println("Their recon has found one of our ships; it's been destroyed.");
                ocean[x2][y2] = 3;
                totalPlayer --;
            } else if (ocean[x2][y2] == 3 || ocean[x2][y2] == 5) {
                System.out.println("Good news. The enemy doesn't seem to remember the locations of destroyed ships.");
            } else {
                System.out.println("Their recon failed them. Artillery missed by a long shot.");
                ocean[x2][y2] = 4;
            }
            System.out.println();
            oceanMap();
            System.out.println();
            System.out.println("Your ships: " + totalPlayer + " | " + "Computer ships: " + totalComputer + "\n");
            System.out.println("---------------------------------------\n");
        }

        if (totalComputer == 0) {
            System.out.println("Outstanding marine! Out-fucking-standing. You kicked the computer's ass.");
        } else {
            System.out.println("A lot of good men died today. All for nothing.");
        }


    }
}