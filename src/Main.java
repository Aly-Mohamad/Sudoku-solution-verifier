import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SudokuBoard board = new SudokuBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose the mode to check the sudoku. 0/3/27: ");
        int mode = Integer.parseInt(scanner.next());

        while(mode !=0 && mode != 3 && mode != 27){
            System.out.println("You entered an invalid mode.Try again.");
            System.out.print("Choose the mode to check the sudoku. 0/3/27: ");
            mode = Integer.parseInt(scanner.next());
        }
        List<String> allErrors = new ArrayList<>();

        switch (mode){
            case 0:
                Checker rowChecker = CheckerFactory.createChecker("row", board.getBoard(), -1);
                Checker colChecker = CheckerFactory.createChecker("column", board.getBoard(), -1);
                Checker boxChecker = CheckerFactory.createChecker("box", board.getBoard(), -1);


                rowChecker.run();
                colChecker.run();
                boxChecker.run();

                allErrors.addAll(rowChecker.getErrors());
                allErrors.addAll(colChecker.getErrors());
                allErrors.addAll(boxChecker.getErrors());
                break;

            case 3:
                Checker rowChecker3 = CheckerFactory.createChecker("row", board.getBoard(), -1);
                Checker colChecker3 = CheckerFactory.createChecker("column", board.getBoard(), -1);
                Checker boxChecker3 = CheckerFactory.createChecker("box", board.getBoard(), -1);


                Thread rowThread = new Thread(rowChecker3);
                Thread colThread = new Thread(colChecker3);
                Thread boxThread = new Thread(boxChecker3);

                rowThread.start();
                colThread.start();
                boxThread.start();

                rowThread.join();
                colThread.join();
                boxThread.join();

                allErrors.addAll(rowChecker3.getErrors());
                allErrors.addAll(colChecker3.getErrors());
                allErrors.addAll(boxChecker3.getErrors());
                break;

            case 27:
                List<Thread> threads= new ArrayList<>();
                List<Checker> checkers = new ArrayList<>();

                for (int i = 0; i < 9; i++) {
                    Checker r = CheckerFactory.createChecker("single_row", board.getBoard(), i);
                    checkers.add(r);
                    threads.add(new Thread(r));
                }

                for (int i = 0; i < 9; i++) {
                    Checker c = CheckerFactory.createChecker("single_column", board.getBoard(), i);
                    checkers.add(c);
                    threads.add(new Thread(c));
                }

                for (int i = 0; i < 9; i++) {
                    Checker b = CheckerFactory.createChecker("single_box", board.getBoard(), i);
                    checkers.add(b);
                    threads.add(new Thread(b));
                }


                for(Thread t: threads){
                    t.start();
                }
                for(Thread t : threads){
                    t.join();
                }

                for(Checker ch :checkers){
                    allErrors.addAll(ch.getErrors());
                }
                break;
        }

        if (allErrors.isEmpty()) {
            System.out.println("No errors found - Sudoku is valid!");
        } else {
            System.out.println("Invalid Sudoku!");
            allErrors.forEach(System.out::println);
        }
    }
}
