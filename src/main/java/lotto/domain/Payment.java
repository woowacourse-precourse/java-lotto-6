package lotto.domain;

import lotto.validator.Validator;

public class Payment {
    private int payment;

    public Payment(int payment) {
        validator(payment);
        this.payment = payment;
    }

    private void validator(int payment) {
        Validator.isPositiveNumber(payment);
        Validator.isUnitsOfLottoPrice(payment);
    }

    public int getPayment() {
        return payment;
    }
}
