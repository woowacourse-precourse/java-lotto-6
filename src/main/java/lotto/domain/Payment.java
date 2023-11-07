package lotto.domain;

import lotto.Validator;

public class Payment {
    private int amount = 0;
    private int availableLottoTicketQuantity = 0;
    private final int LOTTO_PRICE = 1000;

    public void storePaymentAmount(int amount) {
        validate(amount);
        this.amount = amount;
        calculateTicketQuantity();
    }

    private void validate(int amount) {
        Validator.validatePaymentAmount(amount);
    }

    private void calculateTicketQuantity() {
        availableLottoTicketQuantity = amount / LOTTO_PRICE;
    }

    public int getAvailableLottoTicketQuantity() {
        return availableLottoTicketQuantity;
    }
}
