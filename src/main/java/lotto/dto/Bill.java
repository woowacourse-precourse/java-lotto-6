package lotto.dto;

import lotto.domain.Amount;
import lotto.domain.TicketSize;

public class Bill {
    private final Amount amount;
    private final TicketSize ticketSize;

    private Bill(Amount amount, TicketSize ticketSize) {
        this.amount = amount;
        this.ticketSize = ticketSize;
    }

    public static Bill createBill(Amount amount, int ticketSize) {
        return new Bill(amount, new TicketSize(ticketSize));
    }

    public Amount getAmount() {
        return amount;
    }

    public TicketSize getTicketSize() {
        return ticketSize;
    }
}
