package lotto.util;

import java.util.regex.Pattern;

public enum Validator {
    INSTANCE;

    private static final Pattern NUMBER = Pattern.compile("[0-9]+");
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String NOT_INTEGER_MESSAGE = "숫자가 아닌 값이 입력되었습니다.";

    public void numberValidate(String value) {
        if (isNotConsistOfNumber(value)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + NOT_INTEGER_MESSAGE);
        }
    }

    private boolean isNotConsistOfNumber(String value) {
        return !NUMBER.matcher(value).matches();
    }
}
