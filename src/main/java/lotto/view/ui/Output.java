package lotto.view.ui;

import lotto.global.exception.ErrorMessage;

public final class Output {
    private static final String NEWLINE = "\n";

    public static void printlnResult(final String result) {
        System.out.println(result);
    }

    public static void printlnFormat(final String message, final Object... args) {
        System.out.println(String.format(message, args));
    }

    public static void printlnFormatWithNewLine(final String message, final Object... args) {
        System.out.print(NEWLINE);
        printlnFormat(message, args);
    }

    public static void printlnMessage(final String message) {
        System.out.println(message);
    }

    public static void printlnMessageWithNewLine(final String messageType) {
        System.out.print(NEWLINE);
        printlnMessage(messageType);
    }
}
