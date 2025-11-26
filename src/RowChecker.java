public class RowChecker extends Checker {
    public RowChecker(int[][] board) {
        super(board);
    }

    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];
                if (num < 1 || num > 9) continue;
                if (seen[num]) {
                    errors.add("Duplicate " + num + " in row " + (i+1));
                }
                seen[num] = true;
            }
        }
    }
}
