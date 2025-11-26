public class ColumnChecker extends Checker {
    public ColumnChecker(int[][] board) {
        super(board);
    }

    @Override
    public void run() {
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            for (int i = 0; i < 9; i++) {
                int num = board[i][j];
                if (num < 1 || num > 9) continue;
                if (seen[num]) {
                    errors.add("Duplicate " + num + " in column " + (j+1));
                }
                seen[num] = true;
            }
        }
    }
}