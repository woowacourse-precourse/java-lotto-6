package lotto.manager;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppManager {

    private static AppManager appManager;

    private AppManager() {

    }

    public static AppManager getInstance() {
        if (appManager == null) {
            appManager = new AppManager();
        }

        return appManager;
    }

    public void handleInvalidInput(String controllerName) {
        try {
            Class<?> entryPointController = Class.forName(controllerName);
            Method handle = entryPointController.getMethod("handle");
            Constructor<?> constructor = entryPointController.getConstructor();
            Object entryPointInstance = constructor.newInstance();

            handle.invoke(entryPointInstance);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            System.err.println(e.getMessage());
        }
    }
}