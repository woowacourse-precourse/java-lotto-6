package lotto.validator;

import static lotto.view.message.ErrorMessage.EMPTY_INPUT;
import static lotto.view.message.ErrorMessage.NOT_NUMBER;

public class InputValidator {
    public static void validateEmpty(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getErrorMessage());
        }
    }

    public static void validateDigit(String purchaseAmount) {
        if (purchaseAmount.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException(NOT_NUMBER.getErrorMessage());
        }
    }
}
