package lotto.view;

import java.util.function.Supplier;

public class InputValidator {

    public static final String PREFIX = "[ERROR]" + " ";

    public static <T> T getValidInput(final Runnable logMethod, final Supplier<T> readLine) {
        logMethod.run();
        try {
            return readLine.get();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getValidInput(logMethod, readLine);
        }
    }

    public static <T> T getValidInput(final Supplier<T> readLine) {
        try {
            return readLine.get();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getValidInput(readLine);
        }
    }

    private static void printErrorMessage(String message) {
        System.out.println(PREFIX + message);
    }
}
