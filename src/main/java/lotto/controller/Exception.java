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

    public static void isNotThousandUnit() {
        throw new IllegalArgumentException(preface + Message.ERROR_IS_NOT_THOUSAND_UNIT.label());
    }

    public static void isNotSixByComma() {
        throw new IllegalArgumentException(preface + Message.ERROR_IS_NOT_SIX_BY_COMMMA.label());
    }

    public static void isOutOfRange() {
        throw new IllegalArgumentException(preface + Message.ERROR_IS_OUT_OF_RANGE.label());
    }

    public static void isNotDistinct() {
        throw new IllegalArgumentException(preface + Message.ERROR_IS_NOT_DISTICNT.label());
    }
}
