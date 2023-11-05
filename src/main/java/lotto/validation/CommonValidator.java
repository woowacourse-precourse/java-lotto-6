package lotto.validation;

import static lotto.validation.constant.Common.EMPTY_MESSAGE;
import static lotto.validation.constant.Common.NULL_MESSAGE;
import static lotto.validation.constant.Common.SPACE_MESSAGE;

public class CommonValidator {

    public void validateInputNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_MESSAGE.getMessage());
        }
    }

    public void validateInputEmpty(String input) {
        if (isEmptyValue(input)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE.getMessage());
        }
    }

    private boolean isEmptyValue(String input) {
        return input.isEmpty();
    }

    public void validateInputSpace(String input) {
        if (isWhitespaceOnly(input)) {
            throw new IllegalArgumentException(SPACE_MESSAGE.getMessage());
        }
    }

    private boolean isWhitespaceOnly(String input) {
        return input.trim().isEmpty();
    }

    public void validateNullEmptySpace(String input) {
        validateInputNull(input);
        validateInputEmpty(input);
        validateInputSpace(input);
    }
}