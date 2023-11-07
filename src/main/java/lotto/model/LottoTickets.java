package lotto.model;

import java.util.List;

public class LottoTickets {
    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public int getSize() {
        return tickets.size();
    }

    protected List<Lotto> getTickets() {
        return tickets.stream().toList();
    }
}
