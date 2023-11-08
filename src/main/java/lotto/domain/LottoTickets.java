package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public int getNumberOfTickets() {
        return tickets.size();
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
