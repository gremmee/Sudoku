// Planon Enterprise Edition Source file: Board.java
// Copyright Planon 1997-2016. All Rights Reserved.
package nl.gremmee.sudoku.core;

import nl.gremmee.sudoku.helper.*;

import java.util.*;

/**
 * Board
 */
public class Board
{
  //~ Instance Variables ---------------------------------------------------------------------------

  private int[][] SUDOKUBOARD = new int[9][9];
  private int[][] SUDOKUHELPERBOARD = new int[27][27];

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new Board object.
   */
  public Board()
  {
    System.out.println("Initializing Board...");
    System.out.println("Initializing HelperBoard...");
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param aNumber DOCUMENT ME!
   * @param aRow    DOCUMENT ME!
   * @param aColumn DOCUMENT ME!
   */
  public void addNumber(int aNumber, int aRow, int aColumn)
  {
    System.out.println("Adding " + aNumber + " on (" + aRow + ", " + aColumn + ")");

    SUDOKUBOARD[aRow - 1][aColumn - 1] = aNumber;

    Set<Class<? extends IHelper>> helpers = Helpers.getInstance().getHelpers();
    Iterator<Class<? extends IHelper>> iter = helpers.iterator();
    while (iter.hasNext())
    {
      try
      {
        IHelper helper = iter.next().newInstance();
        helper.help(aNumber, aRow - 1, aColumn - 1, this);
      }
      catch (InstantiationException e)
      {
        e.printStackTrace();
      }
      catch (IllegalAccessException e)
      {
        e.printStackTrace();
      }
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean done()
  {
    for (int i = 0; i < 9; i++)
    {
      for (int j = 0; j < 9; j++)
      {
        if (SUDOKUBOARD[i][j] == 0)
        {
          return false;
        }
      }
    }
    return true;
  }


  /**
   * DOCUMENT ME!
   *
   * @param aNumber DOCUMENT ME!
   * @param aRow    DOCUMENT ME!
   * @param aColumn DOCUMENT ME!
   */
  public void fillMiniSquare(int aNumber, int aRow, int aColumn)
  {
    int number = aNumber;
    int row = aRow + ((number - 1) / 3);
    int column = aColumn + ((number - 1) % 3);
    SUDOKUHELPERBOARD[row][column] = number;
  }


  /**
   * DOCUMENT ME!
   */
  public void fillrandom()
  {
    for (int i = 0; i < 9; i++)
    {
      for (int j = 0; j < 9; j++)
      {
        SUDOKUBOARD[i][j] = (int) (Math.random() * 9) + 1;
      }
    }
  }


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int[][] getSudokuBoard()
  {
    return SUDOKUBOARD;
  }


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int[][] getSudokuHelperBoard()
  {
    return SUDOKUHELPERBOARD;
  }


  /**
   * DOCUMENT ME!
   *
   * @param  aRow    DOCUMENT ME!
   * @param  aColumn DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public boolean isEmtpy(int aRow, int aColumn)
  {
    return SUDOKUBOARD[aRow][aColumn] == 0;
  }


  /**
   * DOCUMENT ME!
   */
  public void print()
  {
    printBoard();
    printHelperBoard();
  }


  /**
   * DOCUMENT ME!
   */
  public void printBoard()
  {
    System.out.println();
    System.out.println("  012|345|678");
    for (int row = 0; row < 9; row++)
    {
      if (((row % 3) == 0) && (row != 0))
      {
        System.out.println();
        System.out.println("  -----------");
      }
      else
      {
        System.out.println();
      }
      for (int column = 0; column < 9; column++)
      {
        if (column == 0)
        {
          System.out.print((row % 10) + " ");
        }
        if (((column % 3) == 0) && (column != 0))
        {
          System.out.print("|");
        }
        if (SUDOKUBOARD[row][column] != 0)
        {
          System.out.print(SUDOKUBOARD[row][column]);
        }
        else
        {
          System.out.print(" ");
        }
      }
    }
    System.out.println();
  }


  /**
   * DOCUMENT ME!
   */
  public void printHelperBoard()
  {
    System.out.println();
    System.out.println("  012|345|678|901|234|567|890|123|456");
    for (int row = 0; row < 27; row++)
    {
      if (((row % 3) == 0) && (row != 0))
      {
        System.out.println();
        System.out.println("  -----------------------------------");
      }
      else
      {
        System.out.println();
      }
      for (int column = 0; column < 27; column++)
      {
        if (column == 0)
        {
          System.out.print((row % 10) + " ");
        }
        if (((column % 3) == 0) && (column != 0))
        {
          System.out.print("|");
        }
        if (SUDOKUHELPERBOARD[row][column] != 0)
        {
          System.out.print(SUDOKUHELPERBOARD[row][column]);
        }
        else
        {
          System.out.print(" ");
        }
      }
    }
    System.out.println();
  }
}
