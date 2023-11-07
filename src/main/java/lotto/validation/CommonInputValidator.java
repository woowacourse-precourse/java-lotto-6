package lotto.validation;

import static lotto.validation.constant.CommonInputConstant.NUMERIC_FORMAT_MESSAGE;
import static lotto.validation.constant.CommonInputConstant.EMPTY_MESSAGE;
import static lotto.validation.constant.CommonInputConstant.NULL_MESSAGE;
import static lotto.validation.constant.CommonInputConstant.SPACE_MESSAGE;

public class CommonInputValidator {

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

    public void validateInputNumericFormat(String input) {
        if (isNotNumericFormat(input)) {
            throw new IllegalArgumentException(NUMERIC_FORMAT_MESSAGE.getMessage());
        }
    }

    private boolean isNotNumericFormat(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    public void validateCommonError(String input) {
        validateInputNull(input);
        validateInputEmpty(input);
        validateInputSpace(input);
        validateInputNumericFormat(input);
    }

    public void validateNullEmptySpace(String input) {
        validateInputNull(input);
        validateInputEmpty(input);
        validateInputSpace(input);
    }
}