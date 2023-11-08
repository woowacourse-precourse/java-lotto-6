package lotto;

import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private List<Ticket> tickets;

    Tickets(int quantity) {
        createTickets(quantity);
    }

    private void createTickets(int quantity) {
        List<Ticket> tickets = new ArrayList<>();
        for (int number = 1; number <= quantity; number++) {
            tickets.add(new Ticket());
        }
        this.tickets = tickets;
    }
}
