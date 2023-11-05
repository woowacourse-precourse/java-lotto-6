package lotto.validator;

import static lotto.util.Constants.LOTTO_PRICE;

import lotto.message.ExceptionMessage;

public class PurchaseAmountValidator {

    public static void validate(int inputAmount) {
        validateNaturalNumber(inputAmount);
        validateDivisibleByPrice(inputAmount);
    }

    private static void validateNaturalNumber(int inputAmount) {
        if (inputAmount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private static void validateDivisibleByPrice(int inputAmount) {
        if (inputAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INDIVISIBLE_AMOUNT.getMessage());
        }
    }

}
