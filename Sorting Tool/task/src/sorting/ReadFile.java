package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static List<Long> readLongFromFile(String inputFile) {
        File file = new File(inputFile);
        List<Long> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLong()) {
                String[] line = scanner.nextLine().split("\\s+");
                for (String str : line) {
                    long add;
                    try {
                        add = Long.parseLong(str);
                        result.add(add);
                    } catch (NumberFormatException e) {
                        System.out.println(str + " isn't a valid parameter. It's skipped.\n");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + inputFile);
        }
        return result;
    }

    public static List<String> readWordFromFile(String inputFile) {
        File file = new File(inputFile);
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLong()) {
                String[] line = scanner.nextLine().split("\\s+");
                Collections.addAll(result, line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + inputFile);
        }
        return result;
    }

    public static List<String> readLineFromFile(String inputFile) {
        File file = new File(inputFile);
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLong()) {
                result.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + inputFile);
        }
        return result;
    }
}
