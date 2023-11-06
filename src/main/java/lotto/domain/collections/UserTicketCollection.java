package lotto.domain.collections;

import lotto.Lotto;
import net.bytebuddy.pool.TypePool;

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

    public void printUserTicketList() {
        for (Lotto ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
