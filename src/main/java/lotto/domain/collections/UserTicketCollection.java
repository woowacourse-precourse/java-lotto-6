package lotto.domain;

import lotto.Lotto;

import java.util.Collections;
import java.util.List;

public class UserTicketCollection {

    private final List<Lotto> tickets;

    private UserTicketCollection(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static UserTicketCollection of(List<Lotto> tickets) {
        return new UserTicketCollection(tickets);
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
}
