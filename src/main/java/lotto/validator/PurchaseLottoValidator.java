package lotto.validator;

import lotto.exception.ExceptionMessage;

import static lotto.domain.LottoStore.LOTTO_PRICE;

public class PurchaseLottoValidator {
    private static final int MAXIMUM_PRICE = 100000;


    private PurchaseLottoValidator() {
        throw new AssertionError();
    }

    public static void checkAmountRange(int amount) {
        if (isOutOfRange(amount)) {
            throw ExceptionMessage.INVALID_PRICE_RANGE.getException(LOTTO_PRICE, MAXIMUM_PRICE);
        }
    }

    private static boolean isOutOfRange(int amount) {
        return amount < LOTTO_PRICE || amount > MAXIMUM_PRICE;
    }

    public static void checkRemainder(int amount) {
        if (isNonDivisible(amount)) {
            throw ExceptionMessage.NON_DIVISIBLE_AMOUNT.getException();
        }
    }

    private static boolean isNonDivisible(int amount) {
        return amount % LOTTO_PRICE != 0;
    }

}
