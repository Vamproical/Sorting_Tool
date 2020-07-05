package sorting;

public class Main {
    public static void main(final String[] args) {
        String dataType = "word";
        for (String str: args) {
            if (str.equals("-sortIntegers")) {
                dataType = "integers";
                break;
            }
            if (str.equals("long")) {
                dataType = "long";
                break;
            }
            else if (str.equals("line")) {
                dataType = "line";
                break;
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
            case "integers":
                tool.setMethod(new SortingIntegers());
                break;
            default:
                tool.setMethod(new SortingWord());
        }
        tool.sort();
    }
}
