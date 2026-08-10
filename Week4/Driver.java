import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String pw = sc.nextLine();

        System.out.println("\nRules Passed:");
        System.out.println("Length >= 8: " + PasswordChecker.hasLength(pw));
        System.out.println("Contains Uppercase: " + PasswordChecker.hasUppercase(pw));
        System.out.println("Contains Digit: " + PasswordChecker.hasDigit(pw));
        System.out.println("Contains Special Character: " + PasswordChecker.hasSpecialCharacter(pw));

        System.out.println("\nPassword Strength: " + PasswordChecker.strength(pw));

        sc.close();
    }
}