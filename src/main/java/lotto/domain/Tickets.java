package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tickets {
    private final List<Lotto> tickets;

    public Tickets(List<Lotto> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public int getTicketAmount() {
        return tickets.size();
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
}
