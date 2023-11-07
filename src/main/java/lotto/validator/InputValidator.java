package lotto.validator;

import static lotto.config.LottoConfig.MAX_NUMBER;
import static lotto.config.LottoConfig.MIN_NUMBER;
import static lotto.view.message.ErrorMessage.EMPTY_INPUT;
import static lotto.view.message.ErrorMessage.NOT_NUMBER;
import static lotto.view.message.ErrorMessage.NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE;

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

    public static void validateNumberOnlyFromOneToFortyFive(int number) {
        if (number < MIN_NUMBER.getNumber() || number > MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE.getErrorMessage());
        }
    }
}
