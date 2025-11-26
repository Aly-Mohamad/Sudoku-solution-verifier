import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard();
        board.printBoard();

        RowChecker rowChecker = new RowChecker(board.getBoard());
        ColumnChecker colChecker = new ColumnChecker(board.getBoard());
        BoxChecker boxChecker = new BoxChecker(board.getBoard());

        rowChecker.run();
        colChecker.run();
        boxChecker.run();

        List<String> allErrors = new ArrayList<>();
        allErrors.addAll(rowChecker.getErrors());
        allErrors.addAll(colChecker.getErrors());
        allErrors.addAll(boxChecker.getErrors());

        if (allErrors.isEmpty()) {
            System.out.println("No errors found - Sudoku is valid!");
        } else {
            allErrors.forEach(System.out::println);
        }
    }
}
