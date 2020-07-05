package sorting;

public class SortingTool {
    private SortingMethod method;

    public void setMethod(SortingMethod method) {
        this.method = method;
    }

    public void sort() {
        this.method.sort();
    }
}
