// Planon Enterprise Edition Source file: Sudoku.java
// Copyright Planon 1997-2016. All Rights Reserved.
package nl.gremmee.sudoku.game;

import nl.gremmee.sudoku.core.*;
import nl.gremmee.sudoku.helper.*;
import nl.gremmee.sudoku.solution.*;

import java.util.*;

/**
 * Sudoku
 */
public class Sudoku
{
  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param args
   */
  public static void main(String[] args)
  {
    long beginTime = System.currentTimeMillis();
    System.out.println("Starting application " + Sudoku.class.getSimpleName() + "...");
    System.out.println("Initializing...");
    Helpers.getInstance();
    Solvers.getInstance();

    Board board = new Board();
//Easy
//    board.addNumber(1, 1, 9);
//    board.addNumber(1, 2, 5);
//    board.addNumber(1, 6, 8);
//    board.addNumber(1, 9, 4);
//    board.addNumber(2, 2, 3);
//    board.addNumber(2, 4, 4);
//    board.addNumber(2, 8, 7);
//    board.addNumber(3, 2, 1);
//    board.addNumber(3, 4, 2);
//    board.addNumber(3, 5, 7);
//    board.addNumber(3, 6, 6);
//    board.addNumber(3, 8, 5);
//    board.addNumber(4, 1, 6);
//    board.addNumber(4, 5, 3);
//    board.addNumber(5, 5, 9);
//    board.addNumber(5, 7, 6);
//    board.addNumber(6, 3, 5);
//    board.addNumber(6, 9, 1);
//    board.addNumber(7, 1, 2);
//    board.addNumber(7, 3, 4);
//    board.addNumber(7, 7, 5);
//    board.addNumber(7, 8, 9);
//    board.addNumber(8, 5, 1);
//    board.addNumber(8, 8, 3);
//    board.addNumber(8, 9, 7);
//    board.addNumber(9, 1, 3);
//    board.addNumber(9, 2, 7);
//    board.addNumber(9, 4, 9);
//    board.addNumber(9, 6, 1);
//    board.addNumber(9, 9, 8);

//Medium
//    board.addNumber(1, 1, 4);
//    board.addNumber(1, 3, 2);
//    board.addNumber(1, 5, 8);
//    board.addNumber(1, 7, 9);
//    board.addNumber(2, 1, 1);
//    board.addNumber(2, 2, 8);
//    board.addNumber(3, 3, 4);
//    board.addNumber(3, 4, 7);
//    board.addNumber(3, 5, 1);
//    board.addNumber(3, 8, 8);
//    board.addNumber(3, 9, 6);
//    board.addNumber(4, 1, 7);
//    board.addNumber(4, 3, 1);
//    board.addNumber(4, 5, 9);
//    board.addNumber(4, 6, 2);
//    board.addNumber(5, 2, 2);
//    board.addNumber(5, 4, 8);
//    board.addNumber(5, 6, 3);
//    board.addNumber(6, 4, 4);
//    board.addNumber(6, 5, 2);
//    board.addNumber(6, 7, 6);
//    board.addNumber(6, 8, 1);
//    board.addNumber(7, 2, 9);
//    board.addNumber(7, 8, 2);
//    board.addNumber(8, 6, 6);
//    board.addNumber(8, 9, 9);
//    board.addNumber(9, 7, 8);
//    board.addNumber(9, 9, 3);

// Hard
    board.addNumber(1, 2, 5);
    board.addNumber(1, 3, 7);
    board.addNumber(2, 1, 1);
    board.addNumber(2, 6, 7);
    board.addNumber(2, 7, 5);
    board.addNumber(3, 8, 5);
    board.addNumber(3, 9, 9);
    board.addNumber(4, 2, 9);
    board.addNumber(4, 3, 6);
    board.addNumber(5, 3, 5);
    board.addNumber(5, 4, 3);
    board.addNumber(5, 7, 9);
    board.addNumber(5, 8, 1);
    board.addNumber(6, 2, 7);
    board.addNumber(6, 3, 1);
    board.addNumber(6, 6, 8);
    board.addNumber(7, 7, 4);
    board.addNumber(7, 8, 3);
    board.addNumber(8, 4, 9);
    board.addNumber(8, 6, 1);
    board.addNumber(8, 7, 3);
    board.addNumber(9, 2, 3);
    board.addNumber(9, 4, 2);
    board.addNumber(9, 8, 7);

    System.out.println("Running...");

    board.print();
    boolean solved = false;
    do
    {
      Set<Class<? extends ISolver>> solvers = Solvers.getInstance().getSolvers();
      Iterator<Class<? extends ISolver>> iter = solvers.iterator();
      solved = false;
      while (!solved && iter.hasNext())
      {
        try
        {
          ISolver solver = iter.next().newInstance();
          solved = solver.solve(board);
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
      if (solved)
      {
        board.print();
      }
//      board.fillrandom();
//      board.print();
    }
    while (!board.done() && solved);

    System.out.println("Stopping application " + Sudoku.class.getSimpleName() + "...");
    long endTime = System.currentTimeMillis() - beginTime;
    System.out.println("Time (in ms): " + endTime);
  }
}
