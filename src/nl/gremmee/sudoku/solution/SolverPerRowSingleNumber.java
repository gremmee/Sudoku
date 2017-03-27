// Planon Enterprise Edition Source file: SolverPerRowSingleNumber.java
// Copyright Planon 1997-2014. All Rights Reserved.
package nl.gremmee.sudoku.solution;

import nl.gremmee.sudoku.core.*;

/**
 * SolutionPerRow
 */
public class SolverPerRowSingleNumber extends BaseSolver implements ISolver
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
    System.out.println("Solver per Row Single Number...");

    int columnsolve = 0;
    int rowsolve = 0;
    int numbersolve = 0;

    for (int number = 1; number <= 9; number++)
    {
      for (int row = 0; row < 27; row++)
      {
        int count = 0;
        for (int column = 0; column < 27; column++)
        {
          if (aBoard.getSudokuHelperBoard()[row][column] == number)
          {
            count++;
          }
        }
        if (count == 8)
        {
          rowsolve = row;
          for (int column = 0; column < 27; column++)
          {
            if ((column % 3) == 0)
            {
              if (aBoard.getSudokuHelperBoard()[row][column + ((number - 1) % 3)] == 0)
              {
                columnsolve = column + ((number - 1) % 3);
                break;
              }
            }
          }
          numbersolve = number;
          System.out.println("SOLVE " + number + " : row " + rowsolve + " : column " + columnsolve);
          aBoard.addNumber(numbersolve, (rowsolve / 3) + 1, (columnsolve / 3) + 1);
          return true;
        }
      }
    }

    return false;
  }
}
