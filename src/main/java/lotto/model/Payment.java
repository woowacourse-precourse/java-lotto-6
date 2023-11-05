package lotto.model;

import lotto.constants.ExceptionMessages;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    private static final int MINIMUM_PAYMENT_AMOUNT = 1000;
    private static final int ZERO_REMAINDER = 0;
    private final int paymentAmount;
    private final int lottoAmount;

    public Payment(int paymentAmount) {
        validate(paymentAmount);
        this.paymentAmount = paymentAmount;
        this.lottoAmount = calculateLottoAmount(paymentAmount);
    }

    private void validate(int paymentAmount) {
        if (isUnderMinimumPaymentAmount(paymentAmount)) {
            ExceptionMessages.WRONG_RANGE_INPUT.throwException();
        }
        if (isNotDivisiblePaymentAmount(paymentAmount)) {
            ExceptionMessages.NOT_DIVISIBLE_INPUT.throwException();
        }
    }

    private boolean isUnderMinimumPaymentAmount(int paymentAmount) {
        return paymentAmount < MINIMUM_PAYMENT_AMOUNT;
    }

    private boolean isNotDivisiblePaymentAmount(int paymentAmount) {
        return paymentAmount % MINIMUM_PAYMENT_AMOUNT != ZERO_REMAINDER;
    }

    private int calculateLottoAmount(int paymentAmount) {
        return paymentAmount / MINIMUM_PAYMENT_AMOUNT;
    }

    public List<Integer> providePaymentStatus() {
        List<Integer> paymentStatus = new ArrayList<>();
        paymentStatus.add(paymentAmount);
        paymentStatus.add(lottoAmount);

        return paymentStatus;
    }
}
