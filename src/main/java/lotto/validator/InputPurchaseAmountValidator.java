package lotto.validator;

import lotto.view.ErrorMessage;

public class InputPurchaseAmountValidator {

    private static final int LOTTO_PRICE_UNIT = 1000;

    public void validate(String input) {
        validatePurchaseAmountIsBlank(input);
        validatePurchaseAmountIsNumeric(input);
        validatePurchaseAmountIsPositive(input);
        validatePurchaseAmountIsMultipleOfLottoPriceUnit(input);
    }

    private void validatePurchaseAmountIsBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DOES_NOT_BLANK.getMessage());
        }
    }

    private void validatePurchaseAmountIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_NUMERIC.getMessage());
        }
    }

    private void validatePurchaseAmountIsPositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_POSITIVE.getMessage());
        }
    }

    private void validatePurchaseAmountIsMultipleOfLottoPriceUnit(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_MULTIPLE_OF_LOTTO_PRICE_UNIT.getMessage());
        }
    }

}
