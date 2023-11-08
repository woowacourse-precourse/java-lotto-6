package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<Lotto> tickets;

    public LottoTickets() {
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Lotto ticket) {
        tickets.add(ticket);
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
