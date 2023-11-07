package lotto.utils;

import lotto.exception.defaultexception.DefaultErrorMessage;

public class Validator {

    public static void validateInputValue(String[] input) {
        for (String s : input) {
            validateInputValue(s);
        }
    }

    public static void validateInputValue(String s) {
        checkBlankInputValue(s);
        checkWhiteSpaceInputValue(s);
        checkTypeOfInputValue(s);
    }

    private static void checkBlankInputValue(String s) {
        if (s.length() == 0){
            throw DefaultErrorMessage.BLANK_INPUT.getException();
        }
    }

    private static void checkWhiteSpaceInputValue(String s) {
        if (s.contains(" ")) {
            throw DefaultErrorMessage.WHITE_SPACE.getException();
        }
    }

    private static void checkTypeOfInputValue(String s) {
        if (! s.matches("^\\d+$")) {
            throw DefaultErrorMessage.NON_NUMERIC.getException();
        }
    }
}
