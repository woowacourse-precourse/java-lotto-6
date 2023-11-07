package lotto.validator;

import lotto.constant.ErrorMessage;

public abstract class Validator {
    public abstract void validate(String inputString);

    // 공백인 경우
    static void validateEmptyInput(String inputValue) {
        if (inputValue.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR.getMessage());
        }
    }
}
