package lotto.view.io;

/**
 * 일반적인 출력에 대한 기능을 제공합니다.
 */
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
