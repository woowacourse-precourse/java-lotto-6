package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    LottoTickets(final List<LottoTicket> tickets) {
        this.tickets = tickets;
    }
}
