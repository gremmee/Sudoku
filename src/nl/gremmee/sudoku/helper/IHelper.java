// Planon Enterprise Edition Source file: IHelper.java
// Copyright Planon 1997-2014. All Rights Reserved.
package nl.gremmee.sudoku.helper;

import nl.gremmee.sudoku.core.*;

/**
 * IHelper
 *
 * @version $Revision: 1.16 $
 */
public interface IHelper
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
  public void help(int aNumber, int aRow, int aColumn, Board aSudokuHelperBoard);
}
