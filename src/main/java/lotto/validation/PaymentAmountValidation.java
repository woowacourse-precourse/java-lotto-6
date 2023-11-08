package lotto.validation;

import static lotto.constant.ErrorMessage.MULTIPLE_EXCEPTION;
import static lotto.constant.ErrorMessage.ZERO_EXCEPTION;
import static lotto.constant.LottoConstant.LOTTO_PRICE;

public class PaymentAmountValidation {
    private static final int ZERO = 0;

    public static void validatePaymentAmount(int purchaseCost) {
        validateZero(purchaseCost);
        validateMultiple(purchaseCost);
    }

    private static void validateZero(int purchaseCost) {
        if (purchaseCost == ZERO) {
            throw new IllegalArgumentException(ZERO_EXCEPTION.getMessage());
        }
    }

    private static void validateMultiple(int purchaseCost) {
        if (purchaseCost % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MULTIPLE_EXCEPTION.getMessage());
        }
    }
}
