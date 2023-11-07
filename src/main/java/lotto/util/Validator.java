package lotto.util;

import static lotto.constant.ExceptionMessages.MIN_PURCHASE_AMOUNT_EXCEPTION_MESSAGE;
import static lotto.constant.GameOptions.LOTTO_PRICE;

import java.util.List;

public class Validator {

    public static void validatePositiveInteger(Integer number) {
        if (number < 1) {
            throw new IllegalStateException();
        }
    }

    public static void validatePositiveIntegerList(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1) {
                throw new IllegalStateException();
            }
        }
    }

    public static void validatePurchaseAmount(Integer purchaseAmount) {
        validateOverMinimum(purchaseAmount);
        validateDivisibility(purchaseAmount);
    }

    private static void validateDivisibility(Integer purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(MIN_PURCHASE_AMOUNT_EXCEPTION_MESSAGE.toString());
        }
    }

    private static void validateOverMinimum(Integer purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(MIN_PURCHASE_AMOUNT_EXCEPTION_MESSAGE.toString());
        }
    }
}
