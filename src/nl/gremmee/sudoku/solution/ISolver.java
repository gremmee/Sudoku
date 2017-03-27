// Planon Enterprise Edition Source file: ISolver.java
// Copyright Planon 1997-2016. All Rights Reserved.
package nl.gremmee.sudoku.solution;

import nl.gremmee.sudoku.core.*;

/**
 * ISolver
 *
 * @version $Revision: 1.16 $
 */
public interface ISolver
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aBoard aRow               DOCUMENT ME!
   *
   * @return
   */
  public boolean solve(Board aBoard);
}
