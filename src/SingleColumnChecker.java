import java.util.ArrayList;
import java.util.List;

public class SingleColumnChecker extends Checker{
    int col;
    public  SingleColumnChecker(int[][] board, int col){
        super(board);
        this.col = col;
    }

    @Override
    public void run() {
        List<Integer>[] positions = new List[10];

        for (int n = 1; n <= 9; n++) {
            positions[n] = new ArrayList<>();
        }

        for (int row = 0; row < 9; row++) {
            int num = board[row][col];
            if (num >= 1 && num <= 9) {
                positions[num].add(row + 1);
            }
        }

        for (int num = 1; num <= 9; num++) {
            if (positions[num].size() > 1) {
                String entry = "COL " + (col + 1) + ", #" + num + ", " + positions[num];
                errors.add(entry);
            }
        }
    }
}
