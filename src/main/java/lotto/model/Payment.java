package lotto.model;

import lotto.ErrorMessages;

public class Payment {
    private final int payment;

    public Payment(int payment) {
        validatePayment(payment);
        this.payment = payment;
    }

    private void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages
                    .NOT_DIVISIBLE_BY_THOUSAND
                    .getMessage());
        }
    }
}
