package scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerClass {
    static Scanner scanner = new Scanner(System.in);
    static int number;

    public static int getNumber(int startNumber, int endNumber) {
        while (true) {
            System.out.println("input number between " + startNumber + " and " + endNumber);
            try {
                number = scanner.nextInt();
                if (number > (startNumber - 1) && number < (endNumber + 1)) break;
            } catch (InputMismatchException i) {
                System.out.println("input a valid number");
            }
            scanner.nextLine();
        }
        return number;
    }

    public static int getNumber() {
        while (true) {
            try {
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException i) {
                System.out.println("input a valid number");
            }
            scanner.nextLine();
        }
        return number;
    }

    public static String getString() {
        String word = scanner.next();
        return word;
    }

}

