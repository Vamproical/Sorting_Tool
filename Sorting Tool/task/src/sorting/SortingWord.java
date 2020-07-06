package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingWord implements SortingMethod {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sortByNatural() {
        List<String> sortArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("\\s+");
            Collections.addAll(sortArray, line);
        }
        Collections.sort(sortArray);
        System.out.printf("Total numbers: %d.\n", sortArray.size());
        System.out.print("Sorted data: ");
        for (String i : sortArray) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void sortByCount() {
        List<String> sortedDataEntries = new ArrayList<>();
        int entryNumber = 0;
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("\\s+");
            for (String str : line) {
                sortedDataEntries.add(str);
                ++entryNumber;
            }
        }

        ArrayList<String> temp = new ArrayList<>();
        ArrayList<EntryWordAndLine> sorted = new ArrayList<>();
        Collections.sort(sortedDataEntries);
        for (String l : sortedDataEntries) {
            if (!temp.contains(l)) {
                long occurrences = Collections.frequency(sortedDataEntries, l);
                sorted.add(new EntryWordAndLine(l, occurrences));
            }
            temp.add(l);
        }
        System.out.println("Total numbers: " + entryNumber + ".");

        Collections.sort(sorted);

        for (EntryWordAndLine n : sorted) {
            System.out.printf("%s: %d time(s), %.0f%%\n", n.getWord(), n.getFreq(), (((double) n.getFreq() / entryNumber) * 100));

        }
    }
}
