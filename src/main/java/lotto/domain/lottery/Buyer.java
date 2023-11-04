package lotto.domain.lottery;

import lotto.exception.LottoException;

import java.util.Objects;

import static lotto.domain.constants.LottoConstraint.UNIT_PRICE;
import static lotto.exception.ErrorMessage.PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE;
import static lotto.exception.ErrorMessage.PAYMENT_NOT_INTEGER;

public class Buyer {
    private static final int NO_REMAINDER = 0;

    private final int payment;
    private final int ticketCount;

    private Buyer(final String paymentInput) {
        int convertedPayment = convertStringToInt(paymentInput);
        validateUnitPrice(convertedPayment);

        this.payment = convertedPayment;
        this.ticketCount = calculateTicketCount(convertedPayment);
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
        return payment / UNIT_PRICE.getValue();
    }


    private void validateUnitPrice(final int payment) {
        if (isNotDivisibleByUnitPrice(payment)) {
            throw LottoException.from(PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE);
        }
    }

    private boolean isNotDivisibleByUnitPrice(final int payment) {
        return !Objects.equals(calculateRemainder(payment), NO_REMAINDER);
    }

    private static int calculateRemainder(int payment) {
        return payment % UNIT_PRICE.getValue();
    }

    public int getPayment() {
        return payment;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
