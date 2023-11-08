package lotto.domain.payment;

import lotto.constant.PaymentConstant;

import lotto.exception.PaymentException;
import lotto.exception.message.PaymentExceptionMessage;

public record Payment(int ticketPurchaseCount, int amount) implements PaymentConstant {
    public static Payment of(int amount) {
        validateAmount(amount);
        int ticketPurchaseCount = calculateLottoTicketQuantityWithAmount(amount);
        return new Payment(ticketPurchaseCount, amount);
    }

    private static int calculateLottoTicketQuantityWithAmount(int amount) {
        return amount / PAYMENT_UNIT;
    }

    private static void validateAmount(int amount) {
        validateAmountIsPositiveNumber(amount);
        validateAmountIsAligned(amount);
    }

    private static void validateAmountIsPositiveNumber(int amount) {
        if (amount <= 0) {
            throw new PaymentException(PaymentExceptionMessage.INVALID_VALUE);
        }
    }

    private static void validateAmountIsAligned(int amount) {
        if (amount % PAYMENT_UNIT != 0) {
            throw new PaymentException(PaymentExceptionMessage.INVALID_AMOUNT);
        }
    }
}
