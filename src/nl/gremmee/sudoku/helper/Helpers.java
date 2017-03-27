// Planon Enterprise Edition Source file: Helpers.java
// Copyright Planon 1997-2014. All Rights Reserved.
package nl.gremmee.sudoku.helper;

import java.lang.reflect.*;
import java.util.*;

/**
 * Helpers
 */
public class Helpers
{
  //~ Static Variables & Initializers --------------------------------------------------------------

  private static Helpers instance;

  //~ Instance Variables ---------------------------------------------------------------------------

  private final Set<Class<? extends IHelper>> registry;

  //~ Constructors ---------------------------------------------------------------------------------

  /**
   * Creates a new Helpers object.
   */
  private Helpers()
  {
    this.registry = new HashSet<Class<? extends IHelper>>();
    fillRegistry();
  }

  //~ Methods --------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public static Helpers getInstance()
  {
    if (instance == null)
    {
      instance = new Helpers();
    }
    return instance;
  }


  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public Set<Class<? extends IHelper>> getHelpers()
  {
    return this.registry;
  }


  /**
   * DOCUMENT ME!
   */
  private void fillRegistry()
  {
    registerHelper(HelperMiniSquare.class);
    registerHelper(HelperPerColumn.class);
    registerHelper(HelperPerRow.class);
    registerHelper(HelperPerSquare.class);
  }


  /**
   * DOCUMENT ME!
   *
   * @param aClass DOCUMENT ME!
   */
  private void registerHelper(Class<? extends IHelper> aClass)
  {
    assert !Modifier.isAbstract(aClass.getModifiers());

    System.out.print("Registering Helper " + aClass.getSimpleName() + "...");
    if (!this.registry.add(aClass))
    {
      assert false : "Classname: " + aClass.getName() + " already exist.";
    }
    System.out.println("[OK]");
  }
}
