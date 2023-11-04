package lotto.domain.lottery;

import lotto.exception.LottoException;

import java.util.Objects;

import static lotto.domain.constants.LottoConstraint.UNIT_PRICE;
import static lotto.exception.ErrorMessage.PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE;
import static lotto.exception.ErrorMessage.PAYMENT_NOT_INTEGER;

public class Buyer {
    private final int payment;
    private final int ticketCount;

    private Buyer(final String paymentInput) {
        this.payment = convertStringToInt(paymentInput);
        validateUnitPrice(payment);
        this.ticketCount = calculateTicketCount(payment);
    }

    public static Buyer from(final String paymentInput) {
        return new Buyer(paymentInput);
    }

    private int convertStringToInt(final String paymentInput) {
        try {
            return Integer.parseInt(paymentInput);
        } catch (NumberFormatException exception) {
            throw LottoException.of(PAYMENT_NOT_INTEGER, exception);
        }
    }

    private int calculateTicketCount(int payment) {
        return payment % UNIT_PRICE.getValue();
    }


    private void validateUnitPrice(final int paymentAmount) {
        if (isNotDivisibleByUnitPrice(paymentAmount)) {
            throw LottoException.from(PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE);
        }
    }

    private boolean isNotDivisibleByUnitPrice(final int paymentAmount) {
        return !Objects.equals(calculateTicketCount(paymentAmount), 0);
    }

    public int getPayment() {
        return payment;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
