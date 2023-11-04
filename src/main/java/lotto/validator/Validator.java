package lotto.validator;

import lotto.constants.GameNumberConstants;

import java.util.List;

import static lotto.constants.ValidatorConstants.*;

public class Validator {

    private Validator() {}

    public static void validatePurchaseAmount(String input) {

    }

    public static void areAllPrimeNumber(List<String> inputs) {
        inputs.stream().forEach(Validator::isPrimeNumber);
    }

    public static void isPrimeNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_PRIME_NUMBER.getValue());
        }
    }

    public static void isPositiveNumber(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(INPUT_IS_NOT_POSITIVE_NUMBER.getValue());
        }
    }

    public static void isUnitsOfLottoPrice(int input) {
        if (input % GameNumberConstants.LOTTO_PRICE.getValue() == 0) {
            return;
        }
        throw new IllegalArgumentException(String.format(
                INPUT_IS_NOT_IN_UNITS_OF_LOTTO_PRICE.getValue(),
                GameNumberConstants.LOTTO_PRICE.getValue()));
    }

    public static void checkWinningNumberForm(String winningNumber) {
        String regularExpForInput = "[^,]+,(?:[^,]+,)*[^,]+";
        if (!winningNumber.matches(regularExpForInput)) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORM_IS_WRONG.getValue());
        }
    }

}
