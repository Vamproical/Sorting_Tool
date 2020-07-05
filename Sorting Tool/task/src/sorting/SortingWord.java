package sorting;

import java.util.Scanner;

public class SortingWord implements SortingMethod {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sort() {
        int totalWord = 0;
        String maxWord = "";
        int totalMaxWord = 1;
        while (scanner.hasNext()) {
            String word = scanner.next();

            if (word.length() > maxWord.length()) {
                maxWord = word;
                totalMaxWord = 1;
            } else if (word.equals(maxWord)) {
                totalMaxWord++;
            } else if (word.length() == maxWord.length()) {
                int rs = word.compareTo(maxWord);

                if (rs > 0) {
                    maxWord = word;
                    totalMaxWord = 1;
                }
            }
            ++totalWord;
        }
        double percentages = ((double) totalMaxWord / totalWord) * 100;
        System.out.printf("Total words: %d.\n", totalWord);
        System.out.printf("The greatest number: %s (%d time(s), %.0f%%).\n", maxWord, totalMaxWord, percentages);
    }
}
