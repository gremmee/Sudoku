// Planon Enterprise Edition Source file: HelperMiniSquare.java
// Copyright Planon 1997-2014. All Rights Reserved.
package nl.gremmee.sudoku.helper;

import nl.gremmee.sudoku.core.*;

/**
 * HelperMiniSquare
 */
public class HelperMiniSquare extends BaseHelper implements IHelper
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
    System.out.println("Helper per Mini Square...");

    int row = ((aRow) * 3);
    int col = ((aColumn) * 3);

    for (int number = 1; number <= 9; number++)
    {
      aSudokuHelperBoard.fillMiniSquare(number, row, col);
    }
  }
}
