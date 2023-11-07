package lotto.utils;

import lotto.code.GameMessage;

/**
 * PrintUtils
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
public class PrintUtils {

    private PrintUtils() {
        throw new IllegalStateException("Utility class");
    }
    public static void print(GameMessage gameMessage) {
        System.out.println(gameMessage.getMessage());
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
