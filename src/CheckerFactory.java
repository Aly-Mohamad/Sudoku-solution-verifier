public class CheckerFactory {

    public static Checker createChecker(String type, int[][] board, int index) {
        switch (type.toLowerCase()) {

            case "row":
                return new RowChecker(board);

            case "column":
                return new ColumnChecker(board);

            case "box":
                return new BoxChecker(board);

            case "single_row":
                return new SingleRowChecker(board, index);

            case "single_column":
                return new SingleColumnChecker(board, index);

            case "single_box":
                return new SingleBoxChecker(board, index);

            default:
                throw new IllegalArgumentException("Unknown checker type: " + type);
        }
    }
}
