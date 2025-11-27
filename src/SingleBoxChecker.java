public class SingleBoxChecker extends Checker {
    private int boxIndex;

    public SingleBoxChecker(int[][] board, int boxIndex) {
        super(board);
        this.boxIndex = boxIndex;
    }

    @Override
    public void run() {
        int boxRow = (boxIndex / 3) * 3;
        int boxCol = (boxIndex % 3) * 3;

        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = board[boxRow + i][boxCol + j];
                if (num < 1 || num > 9) continue;
                if (seen[num]) {
                    errors.add("Duplicate " + num + " in box (" + (boxRow/3 + 1) + "," + (boxCol/3 + 1) + ")");
                }
                seen[num] = true;
            }
        }
    }
}
