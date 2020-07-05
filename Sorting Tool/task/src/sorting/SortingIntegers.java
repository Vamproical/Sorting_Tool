package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingIntegers implements SortingMethod {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sort() {
        List<Integer> sortArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("\\s+");
            for (String str : line) {
                sortArray.add(Integer.parseInt(str));
            }
        }
        Collections.sort(sortArray);
        System.out.printf("Total numbers: %d.\n", sortArray.size());
        System.out.print("Sorted data: ");
        for (Integer i : sortArray) {
            System.out.print(i + " ");
        }
    }
}
