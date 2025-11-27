public class SingleColumnChecker extends Checker{
    int column;
    public  SingleColumnChecker(int[][] board, int column){
        super(board);
        this.column = column;
    }

    @Override
    public void run() {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 9; i++) {
            int num = board[i][column];
            if (num < 1 || num > 9) continue;
            if (seen[num]) {
                errors.add("Duplicate " + num + " in column " + (column+1));
            }
            seen[num] = true;
        }
    }
}
