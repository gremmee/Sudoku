// Planon Enterprise Edition Source file: SolverPerColumn.java
// Copyright Planon 1997-2014. All Rights Reserved.
package nl.gremmee.sudoku.solution;

import nl.gremmee.sudoku.core.*;

/**
 * SolverPerRow
 */
public class SolverPerColumn extends BaseSolver implements ISolver
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aBoard aRow               DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  @Override public boolean solve(Board aBoard)
  {
    System.out.println("Solver per Column...");

    for (int row = 0; row < 9; row++)
    {
      for (int column = 0; column < 9; column++)
      {
        if (aBoard.isEmtpy(row, column))
        {
          int sqrow = row * 3;
          int sqcol = column * 3;
          int number = findSingleEmptyColumn(sqrow, sqcol, aBoard);
          if (number != 0)
          {
            aBoard.addNumber(number, row + 1, column + 1);
            return true;
          }
        }
      }
    }

    return false;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aRow   DOCUMENT ME!
   * @param  aCol   DOCUMENT ME!
   * @param  aBoard DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  private int findSingleEmptyColumn(int aRow, int aCol, Board aBoard)
  {
    int result = 45;
    int count = 0;
    for (int row = 0; row < 3; row++)
    {
      int helperBoardResult = aBoard.getSudokuHelperBoard()[aRow + row][aCol];
      result -= helperBoardResult;
      if (helperBoardResult > 0)
      {
        count++;
      }
    }
    if ((result <= 9) && (count == 8))
    {
      return result;
    }
    return 0;
  }
}
