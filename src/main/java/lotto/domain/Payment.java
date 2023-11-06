package lotto.domain;

import static lotto.validator.Validator.validatePayment;

import lotto.LottoRule;

public class Payment {

    private final int payment;

    public Payment(int payment) {
        validatePayment(payment);
        this.payment = payment;
    }

    public int getLottoCount() {
        return this.payment / LottoRule.LOTTO_PRICE.value();
    }

}
