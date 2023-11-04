package lotto.domain;

import lotto.constant.ExceptionMessage;

public class LottoCounter {

    private static final int PAYMENT_UNIT = 1000;
    private final int ticketCount;

    public LottoCounter(int payment) {
        validatePayment(payment);
        this.ticketCount = calculateTicketCount(payment);
    }

    private void validatePayment(int payment) {
        if (payment % PAYMENT_UNIT != 0) {
            ExceptionMessage message = ExceptionMessage.INVALID_PAYMENT_UNIT;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private int calculateTicketCount(int payment) {
        return payment / PAYMENT_UNIT;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
