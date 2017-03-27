// Planon Enterprise Edition Source file: HelperPerSquare.java
// Copyright Planon 1997-2014. All Rights Reserved.
package nl.gremmee.sudoku.helper;

import nl.gremmee.sudoku.core.*;

/**
 * HelperPerSquare
 */
public class HelperPerSquare extends BaseHelper implements IHelper
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
    System.out.println("Helper per Square...");

    int row = ((aRow) * 3);
    int column = ((aColumn) * 3);

    int startcolumn = column - (column % 9);
    int startrow = row - (row % 9);

    for (int i = 0; i < 3; i++)
    {
      for (int j = 0; j < 3; j++)
      {
        aSudokuHelperBoard.fillMiniSquare(aNumber, startrow, startcolumn);
        startcolumn += 3;
      }
      startrow += 3;
      startcolumn = column - (column % 9);
    }
  }
}
