package sorting;

public class SortingTool {
    private SortingMethod method;
    private final String sortingType;

    public SortingTool(String sortingType) {
        this.sortingType = sortingType;
    }

    public void setMethod(SortingMethod method) {
        this.method = method;
    }

    public void sort() {
        if (sortingType.equals("byCount")) {
            this.method.sortByCount();
        } else {
            this.method.sortByNatural();
        }
    }
}
