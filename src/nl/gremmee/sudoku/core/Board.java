package nl.gremmee.sudoku.core;

import java.util.Iterator;
import java.util.Set;

import nl.gremmee.sudoku.helper.Helpers;
import nl.gremmee.sudoku.helper.IHelper;

public class Board {
    private int[][] SUDOKUBOARD = new int[9][9];
    private int[][] SUDOKUHELPERBOARD = new int[27][27];

    public Board() {
        System.out.println("Initializing Board...");
        System.out.println("Initializing HelperBoard...");
    }

    public void addNumber(int aNumber, int aRow, int aColumn) {
        System.out.println("Adding " + aNumber + " on (" + aRow + ", " + aColumn + ")");

        SUDOKUBOARD[aRow - 1][aColumn - 1] = aNumber;

        Set<Class<? extends IHelper>> helpers = Helpers.getInstance().getHelpers();
        Iterator<Class<? extends IHelper>> iter = helpers.iterator();
        while (iter.hasNext()) {
            try {
                IHelper helper = iter.next().newInstance();
                helper.help(aNumber, aRow - 1, aColumn - 1, this);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean done() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (SUDOKUBOARD[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void fillMiniSquare(int aNumber, int aRow, int aColumn) {
        int number = aNumber;
        int row = aRow + ((number - 1) / 3);
        int column = aColumn + ((number - 1) % 3);
        SUDOKUHELPERBOARD[row][column] = number;
    }

    public void fillrandom() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SUDOKUBOARD[i][j] = (int) (Math.random() * 9) + 1;
            }
        }
    }

    public int[][] getSudokuBoard() {
        return SUDOKUBOARD;
    }

    public int[][] getSudokuHelperBoard() {
        return SUDOKUHELPERBOARD;
    }

    public boolean isEmtpy(int aRow, int aColumn) {
        return SUDOKUBOARD[aRow][aColumn] == 0;
    }

    public void print() {
        printBoard();
        printHelperBoard();
    }

    public void printBoard() {
        System.out.println();
        System.out.println("  012|345|678");
        for (int row = 0; row < 9; row++) {
            if (((row % 3) == 0) && (row != 0)) {
                System.out.println();
                System.out.println("  -----------");
            } else {
                System.out.println();
            }
            for (int column = 0; column < 9; column++) {
                if (column == 0) {
                    System.out.print((row % 10) + " ");
                }
                if (((column % 3) == 0) && (column != 0)) {
                    System.out.print("|");
                }
                if (SUDOKUBOARD[row][column] != 0) {
                    System.out.print(SUDOKUBOARD[row][column]);
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }

    public void printHelperBoard() {
        System.out.println();
        System.out.println("  012|345|678|901|234|567|890|123|456");
        for (int row = 0; row < 27; row++) {
            if (((row % 3) == 0) && (row != 0)) {
                System.out.println();
                System.out.println("  -----------------------------------");
            } else {
                System.out.println();
            }
            for (int column = 0; column < 27; column++) {
                if (column == 0) {
                    System.out.print((row % 10) + " ");
                }
                if (((column % 3) == 0) && (column != 0)) {
                    System.out.print("|");
                }
                if (SUDOKUHELPERBOARD[row][column] != 0) {
                    System.out.print(SUDOKUHELPERBOARD[row][column]);
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
}
