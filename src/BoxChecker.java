public class BoxChecker extends Checker {
    public BoxChecker(int[][] board) {
        super(board);
    }

    @Override
    public void run() {
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                boolean[] seen = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int num = board[boxRow * 3 + i][boxCol * 3 + j];
                        if (num < 1 || num > 9) continue;
                        if (seen[num]) {
                            errors.add("Duplicate " + num + " in box (" + (boxRow+1) + "," + (boxCol+1) + ")");
                        }
                        seen[num] = true;
                    }
                }
            }
        }
    }
}