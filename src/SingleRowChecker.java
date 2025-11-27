import java.util.ArrayList;
import java.util.List;

public class SingleRowChecker extends Checker{
    int row;
    public SingleRowChecker(int[][] board,int row) {
        super(board);
        this.row = row;
    }

    @Override
    public void run() {
        List<Integer>[] positions = new List[10];

        for (int n = 1; n <= 9; n++) {
            positions[n] = new ArrayList<>();
        }

        for (int col = 0; col < 9; col++) {
            int num = board[row][col];
            if (num >= 1 && num <= 9) {
                positions[num].add(col + 1);
            }
        }

        for (int num = 1; num <= 9; num++) {
            if (positions[num].size() > 1) {
                String entry = "ROW " + (row + 1) + ", #" + num + ", " + positions[num];
                errors.add(entry);
            }
        }
    }
}
