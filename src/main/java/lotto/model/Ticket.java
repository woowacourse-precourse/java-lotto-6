package lotto.model;

import java.util.List;

public class Ticket {
    private List<Lotto> tickets;

    public Ticket(List<Lotto> tickets) {
        this.tickets = tickets;
    }
    
    public List<Lotto> getLottos() {
        return tickets;
    }
}
