package lotto.controller;

import lotto.view.Message;

public class Exception {

    private static final String preface = "[ERROR] ";

    public static void isNotNumber() {
        handleException(Message.ERROR_IS_NOT_NUMBER);
    }

    public static void isNotPlusInt() {
        handleException(Message.ERROR_IS_NOT_PLUS_INT);
    }

    public static void isNotThousandUnit() {
        handleException(Message.ERROR_IS_NOT_THOUSAND_UNIT);
    }

    public static void isNotSixByComma() {
        handleException(Message.ERROR_IS_NOT_SIX_BY_COMMMA);
    }

    public static void isOutOfRange() {
        handleException(Message.ERROR_IS_OUT_OF_RANGE);
    }

    public static void isNotDistinct() {
        handleException(Message.ERROR_IS_NOT_DISTICNT);
    }

    private static void handleException(Message message) {
        try {
            throw new IllegalArgumentException(preface + message.label());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
