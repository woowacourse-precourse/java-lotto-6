package lotto.domain;

public class LottoCounter {

    private static final int PAYMENT_UNIT = 1000;
    private final int ticketCount;

    public LottoCounter(int payment) {
        this.ticketCount = calculateTicketCount(payment);
    }

    private int calculateTicketCount(int payment) {
        return payment / PAYMENT_UNIT;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
