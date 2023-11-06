package lotto.util;

public class OutputUtil {

    private OutputUtil() {}

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }
}
