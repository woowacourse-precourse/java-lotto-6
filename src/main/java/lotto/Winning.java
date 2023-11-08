package lotto;

import java.util.Map;

public class Winning {
    private final Map<Ranking, Integer> result;

    Winning(Tickets tickets, Lotto lotto, Bonus bonus) {
        result = tickets.drawAllTickets(lotto, bonus);
    }
}
