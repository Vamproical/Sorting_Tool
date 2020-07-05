package sorting;

import java.util.Scanner;

public class SortingLine implements SortingMethod {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sort() {
        int totalLine = 0;
        String maxLine = "";
        int totalMaxLine = 1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ++totalLine;
            if (line.length() > maxLine.length()) {
                maxLine = line;
                totalMaxLine = 1;
            } else if (line.equals(maxLine)) {
                totalMaxLine++;
            } else if (line.length() == maxLine.length()) {
                int rs = line.compareTo(maxLine);

                if (rs > 0) {
                    maxLine = line;
                    totalMaxLine = 1;
                }
            }
        }
        double percentages = ((double) totalMaxLine / totalLine) * 100;
        System.out.printf("Total lines: %d.\n", totalLine);
        System.out.printf("The longest line:\n%s\n(%d time(s), %.0f%%).\n", maxLine, totalMaxLine, percentages);
    }
}
