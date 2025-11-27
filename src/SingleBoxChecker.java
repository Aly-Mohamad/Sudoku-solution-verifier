import java.util.ArrayList;
import java.util.List;

public class SingleBoxChecker extends Checker {
    private int box;

    public SingleBoxChecker(int[][] board, int box) {
        super(board);
        this.box = box;
    }

    @Override
    public void run() {
        List<String>[] positions = new List[10];

        for (int n = 1; n <= 9; n++) {
            positions[n] = new ArrayList<>();
        }

        int startRow = (box / 3) * 3;
        int startCol = (box % 3) * 3;

        for (int pos = 0; pos < 9; pos++) {
            int r = pos / 3;
            int c = pos % 3;
            int row = startRow + r;
            int col = startCol + c;
            int num = board[row][col];
            if (num >= 1 && num <= 9) {
                positions[num].add(String.valueOf(pos + 1));
            }
        }

        for (int num = 1; num <= 9; num++) {
            if (positions[num].size() > 1) {
                String entry = "BOX " + (box + 1) + ", #" + num + ", " + positions[num];
                errors.add(entry);
            }
        }
    }
}
