package lotto.model;

import java.util.List;

public class LottoTicket {

    private final List<Number> ticket;

    public LottoTicket(List<Number> ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
