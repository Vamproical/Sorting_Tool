package sorting;

public class Main {
    public static void main(final String[] args) {
        String dataType = "word";
        String sortingType = "natural";
        for (String str : args) {
            if (str.equals("byCount")) {
                sortingType = "byCount";
            }
            if (str.equals("long")) {
                dataType = "long";
            } else if (str.equals("line")) {
                dataType = "line";
            }
        }
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
