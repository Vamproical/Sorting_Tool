package sorting;

import java.util.Scanner;

public class SortingWord implements SortingMethod {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sort() {
        int totalWord = 0;
        String maxWord = "";
        int totalMaxWord = 1;
        while (scanner.hasNextLine()) {
            String[] words = scanner.nextLine().split("\\s+");
            totalWord += words.length;
            for (String str : words) {
                if (str.length() > maxWord.length()) {
                    maxWord = str;
                    totalMaxWord = 1;
                } else if (str.compareTo(maxWord) == 0) {
                    totalMaxWord++;
                }
            }
        }
        double percentages = ((double) totalMaxWord / totalWord) * 100;
        System.out.printf("Total words: %d.\n", totalWord);
        System.out.printf("The greatest number: %s (%d time(s), %.0f%%).\n", maxWord, totalMaxWord, percentages);
    }
}
