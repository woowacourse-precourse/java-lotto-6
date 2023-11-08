package lotto.controller;

import lotto.view.Message;

public class Exception {

    private static final String preface = "[ERROR] ";

    public static void isNotNumber() {
        throw new IllegalArgumentException(preface + Message.ERROR_IS_NOT_NUMBER.label());
    }

    public static void isNotPlusInt() {
        throw new IllegalArgumentException(preface + Message.ERROR_IS_NOT_PLUS_INT.label());
    }

    public static boolean isNotThousandUnit() {
        throw new IllegalArgumentException(preface + Message.ERROR_IS_NOT_THOUSAND_UNIT.label());
    }
}
