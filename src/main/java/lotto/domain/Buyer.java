package lotto.domain;

import lotto.domain.parser.Parser;
import lotto.exception.LottoException;

import java.util.Objects;

import static lotto.domain.constants.LottoConstraint.MAXIMUM_PURCHASE_PAYMENT;
import static lotto.domain.constants.LottoConstraint.UNIT_PRICE;
import static lotto.exception.ErrorMessage.*;

public class Buyer {
    private static final int ZERO = 0;

    private final int payment;
    private final int ticketCount;

    private Buyer(final String paymentInput) {
        int convertedPayment = Parser.parseStringToInt(paymentInput);

        validateMinimumPayment(convertedPayment);
        validateMaximumPayment(convertedPayment);
        validateUnitPrice(convertedPayment);

        this.payment = convertedPayment;
        this.ticketCount = calculateTicketCount(convertedPayment);
    }

    public static Buyer from(final String paymentInput) {
        return new Buyer(paymentInput);
    }

    private int calculateTicketCount(int payment) {
        return payment / UNIT_PRICE.getValue();
    }


    private void validateUnitPrice(final int payment) {
        if (isNotDivisibleByUnitPrice(payment)) {
            throw LottoException.from(PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE);
        }
    }

    private void validateMinimumPayment(final int payment) {
        if (isSmallerThanUnitPrice(payment)) {
            throw LottoException.from(NOT_ENOUGH_PAYMENT);
        }
    }

    private void validateMaximumPayment(final int payment) {
        if (isBiggerThanMaximumPayment(payment)) {
            throw LottoException.from(EXCEED_PAYMENT);
        }
    }

    private boolean isSmallerThanUnitPrice(final int payment) {
        return payment < UNIT_PRICE.getValue();
    }

    private boolean isBiggerThanMaximumPayment(final int payment) {
        return payment > MAXIMUM_PURCHASE_PAYMENT.getValue();
    }

    private boolean isNotDivisibleByUnitPrice(final int payment) {
        return !Objects.equals(calculateRemainder(payment), ZERO);
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
