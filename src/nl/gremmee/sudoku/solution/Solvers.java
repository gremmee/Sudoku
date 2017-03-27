// Planon Enterprise Edition Source file: Solvers.java
// Copyright Planon 1997-2014. All Rights Reserved.
package nl.gremmee.sudoku.solution;

import java.lang.reflect.*;
import java.util.*;

/**
 * Solvers
 */
public class Solvers
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static Solvers instance;

  //~ Instance Variables ---------------------------------------------------------------------------

  private final Set<Class<? extends ISolver>> registry;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new Helpers object.
   */
  private Solvers()
  {
    this.registry = new HashSet<Class<? extends ISolver>>();
    fillRegistry();
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static Solvers getInstance()
  {
    if (instance == null)
    {
      instance = new Solvers();
    }
    return instance;
  }


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Set<Class<? extends ISolver>> getSolvers()
  {
    return this.registry;
  }


  /**
   * DOCUMENT ME!
   */
  private void fillRegistry()
  {
    registerSolver(SolverPerColumnSingleNumber.class);
    registerSolver(SolverPerSquare.class);
    registerSolver(SolverPerRowSingleNumber.class);
//    registerSolver(SolverPerRow.class);
//    registerSolver(SolverPerColumn.class);
  }


  /**
   * DOCUMENT ME!
   *
   * @param aClass DOCUMENT ME!
   */
  private void registerSolver(Class<? extends ISolver> aClass)
  {
    assert !Modifier.isAbstract(aClass.getModifiers());

    System.out.print("Registering Solver " + aClass.getSimpleName() + "...");
    if (!this.registry.add(aClass))
    {
      assert false : "Classname: " + aClass.getName() + " already exist.";
    }
    System.out.println("[OK]");
  }
}
