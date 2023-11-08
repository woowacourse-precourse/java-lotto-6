package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<Ranking, Integer> drawAllTickets(Lotto lotto, Bonus bonus) {
        Map<Ranking, Integer> winningResult = new HashMap<>();
        for (Ticket ticket : tickets) {
            int number = 1;
            Ranking ranking = ticket.drawTicket(lotto, bonus);
            if (winningResult.containsKey(ranking)) {
                number = winningResult.get(ranking) + 1;
            }
            winningResult.put(ranking, number);
        }
        return winningResult;
    }
}
