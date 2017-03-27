package nl.gremmee.sudoku.helper;

public abstract class BaseHelper implements IHelper {
    protected void fillMiniSquare(int aNumber, int aRow, int aColumn, int[][] aSudokuHelperBoard) {
        int number = aNumber;
        int row = aRow + ((number - 1) / 3);
        int column = aColumn + ((number - 1) % 3);
        aSudokuHelperBoard[row][column] = number;
    }
}
