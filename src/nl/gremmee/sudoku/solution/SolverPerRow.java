package nl.gremmee.sudoku.solution;

import nl.gremmee.sudoku.core.Board;

public class SolverPerRow extends BaseSolver implements ISolver {
    @Override
    public boolean solve(Board aBoard) {
        System.out.println("Solver per Row...");

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                int sqrow = row * 3;
                int sqcol = column * 3;
                if (aBoard.isEmtpy(row, column)) {
                    int number = findSingleEmptyColumn(sqrow, sqcol, aBoard);
                    if (number != 0) {
                        aBoard.addNumber(number, row + 1, column + 1);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int findSingleEmptyColumn(int sqrow, int sqcol, Board aBoard) {
        int result = 45;
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int helperBoardResult = aBoard.getSudokuHelperBoard()[sqrow + row][sqcol + col];
                result -= helperBoardResult;
                if (helperBoardResult > 0) {
                    count++;
                }
            }
        }
        if ((result <= 9) && (count == 8)) {
            return result;
        }
        return 0;
    }
}
