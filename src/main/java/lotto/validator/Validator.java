package lotto.validator;

import static lotto.validator.constants.ExceptionMessage.BLANK_ERROR;

public interface Validator {
    void validate(String string);
    default void isBlank(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR.message());
        }
    }
}
