package lotto.view.ui;

import static lotto.view.constants.SymbolType.NEWLINE;

import lotto.view.constants.MessageType;

public final class Output {
    public static void printlnResult(String result) {
        System.out.println(result);
    }

    public static void printlnFormat(MessageType message, Object... args) {
        System.out.println(String.format(message.getMessage(), args));
    }

    public static void printlnFormatWithNewLine(MessageType message, Object... args) {
        System.out.print(NEWLINE.getSymbol());
        printlnFormat(message, args);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    public static void printlnMessageWithNewLine(MessageType messageType) {
        System.out.print(NEWLINE.getSymbol());
        printlnMessage(messageType);
    }
}
