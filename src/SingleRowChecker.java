public class SingleRowChecker extends Checker{
    int row;
    public SingleRowChecker(int[][] board,int row) {
        super(board);
        this.row = row;
    }

    @Override
    public void run() {
        boolean[] seen = new boolean[10];
        for (int j = 0; j < 9; j++) {
            int num = board[row][j];
            if (num < 1 || num > 9) continue;
            if (seen[num]) {
                errors.add("Duplicate " + num + " in row " + (row+1));
            }
            seen[num] = true;
        }
    }
}
