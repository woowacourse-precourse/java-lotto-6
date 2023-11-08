package lotto.domain;

import lotto.Constants;
import lotto.Validator;

public class Payment {
    private int amount = 0;
    private int availableLottoTicketQuantity = 0;

    public void storePaymentAmount(int amount) {
        validate(amount);
        this.amount = amount;
        calculateTicketQuantity();
    }

    private void validate(int amount) {
        Validator.validatePaymentAmount(amount);
    }

    private void calculateTicketQuantity() {
        availableLottoTicketQuantity = amount / Constants.LOTTO_TICKET_PRICE.getValue();
    }

    public int getAvailableLottoTicketQuantity() {
        return availableLottoTicketQuantity;
    }
}
