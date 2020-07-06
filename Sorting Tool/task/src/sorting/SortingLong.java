package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingLong implements SortingMethod {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sortByNatural(String inputFile, String outputFile) {
        List<Long> sortArray = new ArrayList<>();
        if (!inputFile.equals("")) {
            sortArray = ReadFile.readLongFromFile(inputFile);
        } else {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\s+");
                for (String str : line) {
                    long add;
                    try {
                        add = Long.parseLong(str);
                        sortArray.add(add);
                    } catch (NumberFormatException e) {
                        System.out.println(str + " isn't a valid parameter. It's skipped.\n");
                    }
                }
            }
        }
        Collections.sort(sortArray);
        if (!outputFile.equals("")) {
            WriteFile.writeLongToFile(outputFile, sortArray);
        } else {
            System.out.printf("Total numbers: %d.\n", sortArray.size());
            System.out.print("Sorted data: ");
            for (Long i : sortArray) {
                System.out.print(i + " ");
            }
        }
    }

    @Override
    public void sortByCount(String inputFile, String outputFile) {
        List<Long> sortedDataEntries = new ArrayList<>();
        if (!inputFile.equals("")) {
            sortedDataEntries = ReadFile.readLongFromFile(inputFile);
        } else {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\s+");
                for (String str : line) {
                    long add;
                    try {
                        add = Long.parseLong(str);
                        sortedDataEntries.add(add);
                    } catch (NumberFormatException e) {
                        System.out.println(str + " isn't a valid parameter. It's skipped.\n");
                    }
                }
            }
        }
        List<Long> temp = new ArrayList<>();
        List<EntryLong> sorted = new ArrayList<>();
        Collections.sort(sortedDataEntries);
        for (Long l : sortedDataEntries) {
            if (!temp.contains(l)) {
                long occurrences = Collections.frequency(sortedDataEntries, l);
                sorted.add(new EntryLong(l, occurrences));
            }
            temp.add(l);
        }
        if (!outputFile.equals("")) {
            WriteFile.writeLongToFileByCount(outputFile, sorted, sortedDataEntries.size());
        } else {
            System.out.println("Total numbers: " + sortedDataEntries.size() + ".");
            Collections.sort(sorted);
            for (EntryLong n : sorted) {
                System.out.printf("%d: %d time(s), %.0f%%\n", n.getNumber(), n.getFreq(), (((double) n.getFreq() / sortedDataEntries.size()) * 100));
            }
        }
    }
}
