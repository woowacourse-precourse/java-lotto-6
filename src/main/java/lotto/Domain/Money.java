package lotto.Domain;

import lotto.Constant.Constant;

public class Money {

    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final String NOT_NUMBER_MESSAGE = "숫자만 입력해야 합니다.";
    private final int value;

    public Money(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        validateIsNumber(value);
    }

    private void validateIsNumber(String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            String errorMessage = Constant.ERROR_PREFIX + NOT_NUMBER_MESSAGE;
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
