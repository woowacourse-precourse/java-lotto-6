package lotto.util;

import java.util.regex.Pattern;

public enum Validator {
    INSTANCE;

    private static final Pattern NUMBER = Pattern.compile("[0-9]+");
    private static final String NOT_INTEGER_MESSAGE = "숫자가 아닌 값이 입력되었습니다.";

    public void numberValidate(String value) {
        ExceptionMessageGenerator exceptionMessageGenerator = ExceptionMessageGenerator.INSTANCE;

        if (isNotConsistOfNumber(value)) {
            throw new IllegalArgumentException(
                    exceptionMessageGenerator.makeMessage(NOT_INTEGER_MESSAGE));
        }
    }

    private boolean isNotConsistOfNumber(String value) {
        return !NUMBER.matcher(value).matches();
    }
}
