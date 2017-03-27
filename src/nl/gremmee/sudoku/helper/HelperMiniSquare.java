package nl.gremmee.sudoku.helper;

import nl.gremmee.sudoku.core.Board;

public class HelperMiniSquare extends BaseHelper implements IHelper {
    @Override
    public void help(int aNumber, int aRow, int aColumn, Board aSudokuHelperBoard) {
        System.out.println("Helper per Mini Square...");

        int row = ((aRow) * 3);
        int col = ((aColumn) * 3);

        for (int number = 1; number <= 9; number++) {
            aSudokuHelperBoard.fillMiniSquare(number, row, col);
        }
    }
}
