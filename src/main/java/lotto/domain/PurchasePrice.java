package lotto.domain;

import static lotto.constant.ErrorMessage.NOT_DIVISIBLE_MESSAGE;

import lotto.validator.InputValidator;
import lotto.view.Output;

public class PurchasePrice {
    //static 적어주어야하나
    private static final int NOT_DIVISIBLE_VALUE = 1;
    private static final int UNIT_PRICE = 1000;
    private final int price;

    private PurchasePrice(String input) {
        validate(input);
        price = Integer.parseInt(input);
    }

    public static PurchasePrice from(String input) {
        return new PurchasePrice(input);
    }

    private void validate(String input) {
        InputValidator.onlyNumber(input);
        InputValidator.inRange(input);
        validateDivisible(Integer.parseInt(input));
    }

    private void validateDivisible(int price) {
        if (price % UNIT_PRICE == NOT_DIVISIBLE_VALUE) {
            Output.errorMessage(NOT_DIVISIBLE_MESSAGE);
            throw new IllegalArgumentException(NOT_DIVISIBLE_MESSAGE);
        }
    }
}
