package lotto.domain;

import static lotto.LottoRule.LOTTO_PRICE;
import static lotto.validator.Validator.validatePayment;

public class Payment {
    private final int payment;

    public Payment(int payment) {
        validatePayment(payment);
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }

    public int getLottoCount() {
        return this.payment / LOTTO_PRICE.value();
    }
}
