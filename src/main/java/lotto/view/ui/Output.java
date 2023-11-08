package lotto.view.ui;

import static lotto.view.constants.SymbolType.NEWLINE;

public final class Output {
    public static void printlnResult(String result) {
        System.out.println(result);
    }

    public static void printlnFormat(String message, Object... args) {
        System.out.println(String.format(message, args));
    }

    public static void printlnFormatWithNewLine(String message, Object... args) {
        System.out.print(NEWLINE.getSymbol());
        printlnFormat(message, args);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printlnMessageWithNewLine(String messageType) {
        System.out.print(NEWLINE.getSymbol());
        printlnMessage(messageType);
    }
}
