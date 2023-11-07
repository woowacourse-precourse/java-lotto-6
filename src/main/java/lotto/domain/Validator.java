package lotto.domain;

import static lotto.domain.ErrorMessage.*;

public class Validator {

    private Validator() {
        throw new IllegalStateException("");
    }

    public static void validatePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(NOT_MULTIPLES_OF_THOUSANDS);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT);
        }
    }

    public static void validateNumbers(String input) {
        String[] numberStrings = input.replace(" ", "").split(",");
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS);
        }
        for (String numberString : numberStrings) {
            if (!numberString.matches("^\\d+$")) {
                throw new IllegalArgumentException(OUT_OF_RANGE);
            }
            validateLottoNumber(numberString);
        }
    }

    public static void validateLottoNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException(OUT_OF_RANGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}