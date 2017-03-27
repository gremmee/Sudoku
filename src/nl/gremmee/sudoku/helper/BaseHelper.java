// Planon Enterprise Edition Source file: BaseHelper.java
// Copyright Planon 1997-2014. All Rights Reserved.
package nl.gremmee.sudoku.helper;

/**
 * BaseHelper
 */
public abstract class BaseHelper implements IHelper
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param aNumber            DOCUMENT ME!
   * @param aRow               DOCUMENT ME!
   * @param aColumn            DOCUMENT ME!
   * @param aSudokuHelperBoard DOCUMENT ME!
   */
  protected void fillMiniSquare(int aNumber, int aRow, int aColumn, int[][] aSudokuHelperBoard)
  {
    int number = aNumber;
    int row = aRow + ((number - 1) / 3);
    int column = aColumn + ((number - 1) % 3);
    aSudokuHelperBoard[row][column] = number;
  }
}
