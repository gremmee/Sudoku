// Planon Enterprise Edition Source file: HelperPerRow.java
// Copyright Planon 1997-2014. All Rights Reserved.
package nl.gremmee.sudoku.helper;

import nl.gremmee.sudoku.core.*;

/**
 * HelperPerRow
 */
public class HelperPerRow extends BaseHelper implements IHelper
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
  @Override public void help(int aNumber, int aRow, int aColumn, Board aSudokuHelperBoard)
  {
    System.out.println("Helper per Row...");

    int row = aRow * 3;

    for (int i = 0; i < 27; i++)
    {
      if (i == row)
      {
        for (int j = 0; j < 27; j++)
        {
          if ((j % 3) == 0)
          {
            aSudokuHelperBoard.fillMiniSquare(aNumber, i, j);
          }
        }
      }
    }
  }
}
