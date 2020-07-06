package sorting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteFile {

    public static void writeLongToFile(String outputFile, List<Long> store) {
        File file = new File(outputFile);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println("Total numbers: " + store.size() + ".");
            for (Long i : store) {
                printWriter.print(i + " ");
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public static void writeLongToFileByCount(String outputFile, List<EntryLong> store, int freq) {
        File file = new File(outputFile);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println("Total numbers: " + store.size() + ".");
            for (EntryLong n : store) {
                System.out.printf("%d: %d time(s), %.0f%%\n", n.getNumber(), n.getFreq(), (((double) n.getFreq() / freq) * 100));
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public static void writeWordAndLineToFile(String outputFile, List<String> store) {
        File file = new File(outputFile);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.printf("Total numbers: %d.\n", store.size());
            printWriter.print("Sorted data: ");
            for (String i : store) {
                printWriter.print(i + " ");
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public static void writeWordAndLineToFileByCount(String outputFile, List<EntryWordAndLine> store, int freq) {
        File file = new File(outputFile);

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.printf("Total numbers: %d.\n", store.size());
            for (EntryWordAndLine n : store) {
                printWriter.printf("%s: %d time(s), %.0f%%\n", n.getWord(), n.getFreq(), (((double) n.getFreq() / freq) * 100));
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}
