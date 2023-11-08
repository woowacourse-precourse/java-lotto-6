package lotto.view.ui;

public final class Output {
    private static final String NEWLINE = "\n";

    public static void printlnResult(String result) {
        System.out.println(result);
    }

    public static void printlnFormat(String message, Object... args) {
        System.out.println(String.format(message, args));
    }

    public static void printlnFormatWithNewLine(String message, Object... args) {
        System.out.print(NEWLINE);
        printlnFormat(message, args);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printlnMessageWithNewLine(String messageType) {
        System.out.print(NEWLINE);
        printlnMessage(messageType);
    }
}
