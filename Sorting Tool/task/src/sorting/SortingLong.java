package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingLong implements SortingMethod {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sortByNatural() {
        List<Long> sortArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("\\s+");
            for (String str : line) {
                sortArray.add(Long.parseLong(str));
            }
        }
        Collections.sort(sortArray);
        System.out.printf("Total numbers: %d.\n", sortArray.size());
        System.out.print("Sorted data: ");
        for (Long i : sortArray) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void sortByCount() {
        List<Long> sortedDataEntries = new ArrayList<>();
        int entryNumber = 0;
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("\\s+");
            for (String str : line) {
                Long forAdd = Long.parseLong(str);
                sortedDataEntries.add(forAdd);
                ++entryNumber;
            }
        }

        ArrayList<Long> temp = new ArrayList<>();
        ArrayList<EntryLong> sorted = new ArrayList<>();
        Collections.sort(sortedDataEntries);
        for (Long l : sortedDataEntries) {
            if (!temp.contains(l)) {
                long occurrences = Collections.frequency(sortedDataEntries, l);
                sorted.add(new EntryLong(l, occurrences));
            }
            temp.add(l);
        }
        System.out.println("Total numbers: " + entryNumber + ".");

        Collections.sort(sorted);

        for (EntryLong n : sorted) {
            System.out.printf("%d: %d time(s), %.0f%%\n", n.getNumber(), n.getFreq(), (((double) n.getFreq() / entryNumber) * 100));

        }
    }
}
