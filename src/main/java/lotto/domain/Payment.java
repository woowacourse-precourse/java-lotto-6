package lotto.domain;

import lotto.validator.Validator;

public class Payment {
    private int payment;

    public Payment(int payment) {
        Validator.isPositiveNumber(payment);
        Validator.isUnitsOfLottoPrice(payment);
        this.payment = payment;
    }

    private void validator() {
    }

    public int getPayment() {
        return payment;
    }
}
