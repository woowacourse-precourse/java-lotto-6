package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> tickets;

    public Lottos(int size) {
        List<Lotto> tickets = new ArrayList<>();
        while (tickets.size() != size) {
            tickets.add(createTicket());
        }
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return this.tickets;
    }
}
