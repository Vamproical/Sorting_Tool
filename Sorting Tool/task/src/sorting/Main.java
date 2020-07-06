package sorting;

public class Main {
    public static void main(final String[] args) {
        String dataType = "word";
        String sortingType = "natural";
        boolean flag = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-dataType")) {
                try {
                    switch (args[i + 1]) {
                        case "long":
                        case "word":
                        case "line":
                            dataType = args[i + 1];
                            break;
                        default:
                            System.out.println("No data type defined!");
                            flag = true;
                            break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("No data type defined!");
                    flag = true;
                }
            } else if (args[i].equals("-sortingType")) {
                try {
                    switch (args[i + 1]) {
                        case "byCount":
                        case "natural":
                            sortingType = args[i + 1];
                            break;
                        default:
                            System.out.println("No sorting type defined!");
                            flag = true;
                            break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("No sorting type defined!");
                    flag = true;
                }
            }
        }
        if (!flag) {
            SortingTool tool = new SortingTool(sortingType);
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
}
