package lotto.validators;

import lotto.constant.PrintMessages;

import static lotto.constant.LottoConfig.PURCHASE_PRICE;


public class InputValidator {
    public static void validatePriceInput(String priceInput) {
        if (!isNumericString(priceInput)) {
            throw new IllegalArgumentException(PrintMessages.ERROR_INPUT_NUMBER);
        }

        if (!isValidUnit(priceInput)) {
            throw new IllegalArgumentException(String.format(PrintMessages.ERROR_PRICE_UNIT, PURCHASE_PRICE.getValue()));
        }
    }

    private static boolean isNumericString(String input) {
        return input.matches("^\\d+$");
    }

    private static boolean isValidUnit(String input) {
        int value = Integer.parseInt(input);
        return (value % PURCHASE_PRICE.getValue()) == 0;
    }
}
