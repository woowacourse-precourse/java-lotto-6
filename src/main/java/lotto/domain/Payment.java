package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_PAYMENT_FORM;
import static lotto.exception.ErrorMessage.INVALID_PAYMENT_RANGE;

public class Payment {
    private final static int PRICE_PER_LOTTO = 1000;

    private final int pay;

    public Payment(int pay) {
        validateRange(pay, PRICE_PER_LOTTO);
        validateDivisibility(pay, PRICE_PER_LOTTO);
        this.pay = pay;
    }

    private void validateRange(int pay, int lottoPrice) {
        if (pay < lottoPrice) {
            throw new IllegalArgumentException(INVALID_PAYMENT_RANGE.getMessage());
        }
    }

    private void validateDivisibility(int pay, int lottoPrice) {
        if (pay % lottoPrice != 0) {
            throw new IllegalArgumentException(INVALID_PAYMENT_FORM.getMessage());
        }
    }
}
