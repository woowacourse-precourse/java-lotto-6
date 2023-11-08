package lotto.domain;

import lotto.exception.NotPositiveLottoTicketsSizeException;

public class TicketSize {
    private final int ticketSize;

    public TicketSize(int ticketSize) {
        validateTicketsSize(ticketSize);
        this.ticketSize = ticketSize;
    }

    private static void validateTicketsSize(int ticketsSize) {
        if (ticketsSize <= 0) {
            throw new NotPositiveLottoTicketsSizeException();
        }
    }

    public int getTicketSize() {
        return ticketSize;
    }
}
