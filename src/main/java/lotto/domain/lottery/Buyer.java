package lotto.domain.lottery;

import lotto.exception.LottoException;

import java.util.Objects;

import static lotto.domain.lottery.constants.LottoConstraint.MAXIMUM_PURCHASE_PAYMENT;
import static lotto.domain.lottery.constants.LottoConstraint.UNIT_PRICE;
import static lotto.exception.ErrorMessage.*;

public class Buyer {
    private static final int INT_ZERO = 0;

    private final int payment;
    private final int ticketCount;

    // Constructor
    private Buyer(final int payment) {

        validateMinimumPayment(payment);
        validateMaximumPayment(payment);
        validateUnitPrice(payment);

        this.payment = payment;
        this.ticketCount = calculateTicketCount(payment);
    }

    // Static Factory Method
    public static Buyer from(final int payment) {
        return new Buyer(payment);
    }

    // Utility Method
    private int calculateTicketCount(final int payment) {
        return payment / UNIT_PRICE.getValue();
    }

    // Exception Handling Method
    private void validateMinimumPayment(final int payment) {
        if (isSmallerThanUnitPrice(payment)) {
            throw LottoException.from(NOT_ENOUGH_PAYMENT);
        }
    }

    private void validateMaximumPayment(final int payment) {
        if (isBiggerThanMaximumPayment(payment)) {
            throw LottoException.from(NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateUnitPrice(final int payment) {
        if (isNotDivisibleByUnitPrice(payment)) {
            throw LottoException.from(PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE);
        }
    }

    // Validation Method
    private boolean isNotDivisibleByUnitPrice(final int payment) {
        return !Objects.equals(calculateRemainder(payment), INT_ZERO);
    }

    private int calculateRemainder(final int payment) {
        return payment % UNIT_PRICE.getValue();
    }

    private boolean isBiggerThanMaximumPayment(final int payment) {
        return payment > MAXIMUM_PURCHASE_PAYMENT.getValue();
    }

    private boolean isSmallerThanUnitPrice(final int payment) {
        return payment < UNIT_PRICE.getValue();
    }

    // Getter
    public int getPayment() {
        return payment;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
