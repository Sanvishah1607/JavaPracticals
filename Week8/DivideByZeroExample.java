import java.util.Scanner;

// Custom exception
class DivideByZeroException extends Exception {

    DivideByZeroException() {
        super("Cannot divide by zero!");
    }
}

public class DivideByZeroExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean success = false;

        while (!success) {

            try {
                // Read first number
                System.out.print("Enter first number: ");
                double num1 = Double.parseDouble(sc.nextLine());

                // Read operator
                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.nextLine().charAt(0);

                // Read second number
                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(sc.nextLine());

                double result;

                // Perform calculation
                switch (op) {

                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':
                        if (num2 == 0) {
                            throw new DivideByZeroException();
                        }
                        result = num1 / num2;
                        break;

                    default:
                        System.out.println("Invalid operator!");
                        continue;
                }

                System.out.println("Result = " + result);

                // Calculation successful
                success = true;

            } catch (NumberFormatException e) {

                System.out.println("Error: Please enter valid numbers.");

            } catch (DivideByZeroException e) {

                System.out.println("Error: " + e.getMessage());

            } finally {

                System.out.println("Attempt completed.");
                System.out.println();
            }
        }

        System.out.println("Calculation successful!");

        sc.close();
    }
}