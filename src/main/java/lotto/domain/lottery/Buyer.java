package lotto.domain.lottery;

import lotto.domain.parser.Parser;
import lotto.exception.LottoException;

import java.util.Objects;

import static lotto.domain.lottery.constants.LottoConstraint.MAXIMUM_PURCHASE_PAYMENT;
import static lotto.domain.lottery.constants.LottoConstraint.UNIT_PRICE;
import static lotto.exception.ErrorMessage.*;

public class Buyer {
    private static final int INT_ZERO = 0;
    
    private final int payment;
    private final int ticketCount;

    private Buyer(final String paymentInput) {
        int parsedPayment = Parser.parseStringToInt(paymentInput);

        validateMinimumPayment(parsedPayment);
        validateMaximumPayment(parsedPayment);
        validateUnitPrice(parsedPayment);

        this.payment = parsedPayment;
        this.ticketCount = calculateTicketCount(parsedPayment);
    }

    public static Buyer from(final String paymentInput) {
        return new Buyer(paymentInput);
    }

    private int calculateTicketCount(final int payment) {
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
        return !Objects.equals(calculateRemainder(payment), INT_ZERO);
    }

    private static int calculateRemainder(final int payment) {
        return payment % UNIT_PRICE.getValue();
    }

    public int getPayment() {
        return payment;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
