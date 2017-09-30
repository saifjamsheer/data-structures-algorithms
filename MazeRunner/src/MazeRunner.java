import java.util.Scanner;

public class MazeRunner {

    Maze myMap = new Maze();

    public static void main(String[] args) {
        MazeRunner intro = new MazeRunner();
        intro.intro();
        MazeRunner move = new MazeRunner();
        move.userMove();
    }

    public void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();

    }

    public void userMove() {
        Scanner input = new Scanner(System.in);
        int numberOfMoves = 0;
        while (myMap.didIWin() != true) {
            System.out.print("Where would you like to move? (R, L, U, D) ");
            String directionToMove = input.nextLine();
            if (directionToMove.toUpperCase().equals("R")) {
                if (myMap.canIMoveRight() == true) {
                    myMap.moveRight();
                    myMap.printMap();
                    numberOfMoves += 1;
                } else if (myMap.isThereAPit("R")) {
                    navigatePit("R");
                } else {
                    System.out.println("Sorry you've hit a wall.");
                }
            } else if (directionToMove.toUpperCase().equals("L")) {
                if (myMap.canIMoveLeft() == true) {
                    myMap.moveLeft();
                    myMap.printMap();
                    numberOfMoves += 1;
                } else if (myMap.isThereAPit("L")) {
                    navigatePit("L");
                } else {
                    System.out.println("Sorry you've hit a wall.");
                }
            } else if (directionToMove.toUpperCase().equals("U")) {
                if (myMap.canIMoveUp() == true) {
                    myMap.moveUp();
                    myMap.printMap();
                    numberOfMoves += 1;
                } else if (myMap.isThereAPit("U")) {
                    navigatePit("U");
                } else {
                    System.out.println("Sorry you've hit a wall.");
                }
            } else if (directionToMove.toUpperCase().equals("D")) {
                if (myMap.canIMoveDown() == true) {
                    myMap.moveDown();
                    myMap.printMap();
                    numberOfMoves += 1;
                } else if (myMap.isThereAPit("D")) {
                    navigatePit("D");
                } else {
                    System.out.println("Sorry you've hit a wall.");
                }
            } else {
                System.out.println("Invalid input. Please follow the instructions.");
            }
            if (numberOfMoves == 50 || numberOfMoves == 75 || numberOfMoves == 90 || numberOfMoves == 100) {
                System.out.println(movesMessage(numberOfMoves));
                if (numberOfMoves == 100) {
                    break;
                }
            }
        }
        if (myMap.didIWin() == true) {
            System.out.println("Congratulations, You made it out alive in " + numberOfMoves + " moves!");
        } else {
            System.out.println("Sorry, but you didn't escape in time- you lose!");
        }
    }

    public static String movesMessage(int moves) {
        if (moves == 50) {
            return "Warning: You have made 50 moves, you have 50 remaining before the maze exit closes.";
        } else if (moves == 75) {
            return "Alert! You have made 75 moves, you only have 25 moves left to escape.";
        } else if (moves == 90) {
            return "DANGER! You have made 90 moves, you only have 10 moves left to escape!!";
        } else if (moves == 100) {
            return "Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[";
        }
        return null;
    }

    public void navigatePit(String direction) {
        System.out.print("Watch out! There's a pit ahead, would you like to jump it? ");
        Scanner input = new Scanner(System.in);
        String pitDecision = input.nextLine();
        if (pitDecision.toLowerCase().charAt(0) == 'y') {
            myMap.jumpOverPit(direction.toUpperCase());
            myMap.printMap();
        } else {
            System.out.println("Choose another direction.");
        }
    }
}
