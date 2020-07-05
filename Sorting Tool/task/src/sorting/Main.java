package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dataType = "word";
        if (args.length >= 1) {
            if (args[1].equals("long")) {
                dataType = "long";
            } else if (args[1].equals("line")) {
                dataType = "line";
            }
        }
        SortingTool tool = new SortingTool();
        switch (dataType) {
            case "long":
                tool.setMethod(new SortingLong());
                break;
            case "line":
                tool.setMethod(new SortingLine());
                break;
            default:
                tool.setMethod(new SortingWord());
        }
        tool.sort();
    }
}
