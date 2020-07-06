package sorting;

public class SortingTool {
    private SortingMethod method;
    private final String sortingType;
    private final String inputFile;
    private final String outputFile;

    public SortingTool(String sortingType, String inputFile, String outputFile) {
        this.sortingType = sortingType;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void setMethod(SortingMethod method) {
        this.method = method;
    }

    public void sort() {
        if (sortingType.equals("byCount")) {
            this.method.sortByCount(inputFile, outputFile);
        } else {
            this.method.sortByNatural(inputFile, outputFile);
        }
    }
}
