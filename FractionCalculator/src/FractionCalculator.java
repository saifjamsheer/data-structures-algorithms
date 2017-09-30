import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("--------------------------------------------------------------------------------------");
        String operation = getOperation(new Scanner(System.in));
        while (!operation.toUpperCase().equals("Q")) {
            Fraction frac1 = getFraction(new Scanner(System.in));
            Fraction frac2 = getFraction(new Scanner(System.in));
            if (operation.equals("+")) {
                Fraction addedFractions = frac1.add(frac2);
                addedFractions.toLowestTerms();;
                System.out.println(frac1 + " + " + frac2 + " = " + addedFractions);
            } else if (operation.equals("-")) {
                Fraction subtractedFractions = frac1.subtract(frac2);
                subtractedFractions.toLowestTerms();
                System.out.println(frac1 + " - " + frac2 + " = " + subtractedFractions);
            } else if (operation.equals("*")) {
                Fraction multipliedFractions = frac1.multiply(frac2);
                multipliedFractions.toLowestTerms();
                System.out.println(frac1 + " * " + frac2 + " = " + multipliedFractions);
            } else if (operation.equals("/")) {
                Fraction dividedFractions = frac1.divide(frac2);
                dividedFractions.toLowestTerms();
                System.out.println(frac1 + " / " + frac2 + " = " + dividedFractions);
            } else {
                boolean equalCheck = frac1.equals(frac2);
                System.out.println(frac1 + " = " + frac2 + " is " + equalCheck);
            }
            System.out.println("--------------------------------------------------------------------------------------");
            operation = getOperation(new Scanner(System.in));
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static String getOperation(Scanner input) {
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String op = input.nextLine();
        while (!op.equals("+") && !op.equals("-") && !op.equals("/") && !op.equals("*") && !op.equals("=") && !op.toUpperCase().equals("Q")) {
            System.out.print("Invalid input, please input one of the following valid inputs (+, -, /, *, = or Q to quit): ");
            op = input.nextLine();
        }
        return op;
    }

    public static boolean validFraction(String input) {
        if (input.indexOf("-") != -1) {
            if (!input.startsWith("-")) {
                return false;
            }
        }
        if (input.indexOf("/") == -1) {
            return isNumber(input);
        } else if (input.substring(input.indexOf("/") + 1).replaceAll("\\s", "").replace("-", "").equals("0")) {
                return false;
        } else {
            String inputNew = input.replace("/", "");
            inputNew.replaceAll("\\s", "");
            return isNumber(inputNew);
        }

    }

    public static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException fail) {
            return false;
        }
    }

    public static Fraction getFraction(Scanner input) {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String frac = input.nextLine();
        while (validFraction(frac) != true) {
            System.out.print("Invalid fraction: Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            frac = input.nextLine();
        }
        if (validFraction(frac) == true) {
            if (frac.indexOf("/") == -1) {
                return new Fraction(Integer.valueOf(frac));
            } else {
                return new Fraction(Integer.valueOf(frac.substring(0, frac.replaceAll("\\s", "").indexOf("/"))), Integer.valueOf(frac.substring(frac.replaceAll("\\s", "").indexOf("/") + 1)));
            }
        }
        return null;
    }
}