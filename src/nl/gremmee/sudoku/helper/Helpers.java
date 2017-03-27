package nl.gremmee.sudoku.helper;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class Helpers {
    private static Helpers instance;
    private final Set<Class<? extends IHelper>> registry;

    private Helpers() {
        this.registry = new HashSet<Class<? extends IHelper>>();
        fillRegistry();
    }

    public static Helpers getInstance() {
        if (instance == null) {
            instance = new Helpers();
        }
        return instance;
    }

    public Set<Class<? extends IHelper>> getHelpers() {
        return this.registry;
    }

    private void fillRegistry() {
        registerHelper(HelperMiniSquare.class);
        registerHelper(HelperPerColumn.class);
        registerHelper(HelperPerRow.class);
        registerHelper(HelperPerSquare.class);
    }

    private void registerHelper(Class<? extends IHelper> aClass) {
        assert !Modifier.isAbstract(aClass.getModifiers());

        System.out.print("Registering Helper " + aClass.getSimpleName() + "...");
        if (!this.registry.add(aClass)) {
            assert false : "Classname: " + aClass.getName() + " already exist.";
        }
        System.out.println("[OK]");
    }
}
