package lotto.view.io;

public class Writer {

    private Writer() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printUsingFormat(String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }
}
