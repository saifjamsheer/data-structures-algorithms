import java.util.Scanner;

public class MathProblems {

    public static void main(String[] args) {
        //multiply();
        //triangleArea();
        solveQuadratic();
    }

    public static void multiply() {

        Scanner first = new Scanner(System.in);
        Scanner second = new Scanner(System.in);
        System.out.print("Enter an integer x: ");
        int x = first.nextInt();
        System.out.print("Enter an integer y: ");
        int y = second.nextInt();
        int result = x*y;
        System.out.println("Answer = " + result);

    }

    public static void triangleArea() {

        Scanner first = new Scanner(System.in);
        Scanner second = new Scanner(System.in);
        System.out.print("Enter the width of the triangle: ");
        double x = first.nextDouble();
        System.out.print("Enter the height of the triangle: ");
        double y = second.nextDouble();
        double result = x*y/2.0;
        System.out.println("Area of Triangle = " + result);

    }

    public static void solveQuadratic() {

        Scanner first = new Scanner(System.in);
        Scanner second = new Scanner(System.in);
        Scanner third = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = first.nextDouble();
        System.out.print("Enter b: ");
        double b = second.nextDouble();
        System.out.print("Enter c: ");
        double c = third.nextDouble();
        double result1 = (-b + Math.sqrt(b*b - 4*a*c))/(2.0*a);
        double result2 = (-b - Math.sqrt(b*b - 4*a*c))/(2.0*a);
        System.out.println("First solution for x = " + result1);
        System.out.println("Second solution for x = " + result2);

    }


}