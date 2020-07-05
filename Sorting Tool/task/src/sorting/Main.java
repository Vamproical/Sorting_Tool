package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countNumbers = 0;
        int countMaxNumber = 0;
        long maxNumber = 0L;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            ++countNumbers;
            if (maxNumber < number) {
                maxNumber = number;
                countMaxNumber = 1;
            } else if (number == maxNumber) {
                countMaxNumber++;
            }
        }
        System.out.println("Total numbers: " + countNumbers + ".");
        System.out.println("The greatest number: " + maxNumber + " (" + countMaxNumber + " time(s)).");
    }
}
