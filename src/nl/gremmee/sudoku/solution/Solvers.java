package nl.gremmee.sudoku.solution;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class Solvers {
    private static Solvers instance;
    private final Set<Class<? extends ISolver>> registry;

    private Solvers() {
        this.registry = new HashSet<Class<? extends ISolver>>();
        fillRegistry();
    }

    public static Solvers getInstance() {
        if (instance == null) {
            instance = new Solvers();
        }
        return instance;
    }

    public Set<Class<? extends ISolver>> getSolvers() {
        return this.registry;
    }

    private void fillRegistry() {
        registerSolver(SolverPerColumnSingleNumber.class);
        registerSolver(SolverPerSquare.class);
        registerSolver(SolverPerRowSingleNumber.class);
        registerSolver(SolverPerRow.class);
        registerSolver(SolverPerColumn.class);
    }

    private void registerSolver(Class<? extends ISolver> aClass) {
        assert !Modifier.isAbstract(aClass.getModifiers());

        System.out.print("Registering Solver " + aClass.getSimpleName() + "...");
        if (!this.registry.add(aClass)) {
            assert false : "Classname: " + aClass.getName() + " already exist.";
        }
        System.out.println("[OK]");
    }
}
