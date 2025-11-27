import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Checker implements Runnable {
    protected int[][] board;
    protected List<String> errors = new ArrayList<>();

    public Checker(int[][] board) {
        this.board = board;
    }

    public List<String> getErrors() {
        if (errors == null) {
            return Collections.emptyList(); // or new ArrayList<>()
        }
        return errors;
    }

    public abstract void run();
}
