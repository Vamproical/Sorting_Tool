package sorting;

public class Main {
    public static void main(final String[] args) {
        String dataType = "word";
        String sortingType = "natural";
        String inputFile = "";
        String outputFile = "";
        boolean flag = false;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-dataType":
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
                    break;
                case "-sortingType":
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
                    break;
                case "-inputFile":
                    try {
                        inputFile = args[i + 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("No input file defined!");
                        flag = true;
                    }
                    break;
                case "-outputFile":
                    try {
                        outputFile = args[i + 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("No output file defined!");
                        flag = true;
                    }
                    break;
            }
        }
        if (!flag) {
            SortingTool tool = new SortingTool(sortingType, inputFile, outputFile);
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
