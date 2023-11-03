package lotto.validator;

import static lotto.constants.ValidatorConstants.*;

public class Validator {

    private static final int LOTTO_PRICE = 1000;

    public static void validatePurchaseAmount(String input) {
        isPrimeNumber(input);
        isPositiveNumber(input);
        isUnitsOfLottoPrice(input);
    }

    private static void isPrimeNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_PRIME_NUMBER.getValue());
        }
    }

    private static void isPositiveNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(INPUT_IS_NOT_POSITIVE_NUMBER.getValue());
        }
    }

    private static void isUnitsOfLottoPrice(String input) {
        if (Integer.parseInt(input) % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException(String.format(INPUT_IS_NOT_IN_UNITS_OF_LOTTO_PRICE.getValue(), LOTTO_PRICE));
    }
}
