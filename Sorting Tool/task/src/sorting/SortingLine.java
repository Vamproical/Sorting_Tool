package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingLine implements SortingMethod {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sortByNatural(String inputFile, String outputFile) {
        List<String> sortArray = new ArrayList<>();
        if (!inputFile.equals("")) {
            sortArray = ReadFile.readLineFromFile(inputFile);
        } else {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sortArray.add(line);
            }
        }
        Collections.sort(sortArray);
        if (!outputFile.equals("")) {
            WriteFile.writeWordAndLineToFile(outputFile, sortArray);
        } else {
            System.out.printf("Total numbers: %d.\n", sortArray.size());
            System.out.println("Sorted data: ");
            for (String i : sortArray) {
                System.out.println(i);
            }
        }
    }

    @Override
    public void sortByCount(String inputFile, String outputFile) {
        List<String> sortedDataEntries = new ArrayList<>();
        if (!inputFile.equals("")) {
            sortedDataEntries = ReadFile.readLineFromFile(inputFile);
        } else {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sortedDataEntries.add(line);
            }
        }
        List<String> temp = new ArrayList<>();
        List<EntryWordAndLine> sorted = new ArrayList<>();
        Collections.sort(sortedDataEntries);
        for (String l : sortedDataEntries) {
            if (!temp.contains(l)) {
                long occurrences = Collections.frequency(sortedDataEntries, l);
                sorted.add(new EntryWordAndLine(l, occurrences));
            }
            temp.add(l);
        }
        Collections.sort(sorted);
        if (!outputFile.equals("")) {
            WriteFile.writeWordAndLineToFileByCount(outputFile, sorted, sortedDataEntries.size());
        } else {
            System.out.println("Total numbers: " + sortedDataEntries.size() + ".");
            for (EntryWordAndLine n : sorted) {
                System.out.printf("%s: %d time(s), %.0f%%\n", n.getWord(), n.getFreq(), (((double) n.getFreq() / sortedDataEntries.size()) * 100));
            }
        }
    }
}
