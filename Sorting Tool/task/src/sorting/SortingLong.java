package sorting;

import java.util.Scanner;

public class SortingLong implements SortingMethod {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sort() {
        int totalNumbers = 0;
        int totalMaxNumber = 0;
        long maxNumber = 0L;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            ++totalNumbers;
            if (maxNumber < number) {
                maxNumber = number;
                totalMaxNumber = 1;
            } else if (number == maxNumber) {
                totalMaxNumber++;
            }
        }
        double percentages = ((double) totalMaxNumber / totalNumbers) * 100;
        System.out.printf("Total numbers: %d.\n", totalNumbers);
        System.out.printf("The greatest number: %d (%d time(s), %.0f%%).\n", maxNumber, totalMaxNumber, percentages);
    }
}
