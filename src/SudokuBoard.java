import java.io.BufferedReader;
import java.io.FileReader;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(String filename) {
        int[][] array = new int[9][9];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < 9) {
                String[] parts = line.split(",");
                for (int j = 0; j < 9; j++) {
                    array[i][j] = Integer.parseInt(parts[j].replaceAll("[^\\d]", ""));
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.board = array;
    }

    public int[][] getBoard() {
        return board;
    }
}
