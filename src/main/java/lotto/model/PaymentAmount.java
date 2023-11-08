package lotto.model;

import lotto.validation.PaymentAmountValidation;

public class PaymentAmount {
    private final int price;

    public PaymentAmount(int price) {
        PaymentAmountValidation.validatePaymentAmount(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
