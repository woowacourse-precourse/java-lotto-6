package lotto;

import java.util.Map;

public class Winning {
    private final Map<Ranking, Integer> result;

    Winning(Tickets tickets, Lotto lotto, Bonus bonus) {
        result = tickets.drawAllTickets(lotto, bonus);
    }

    public int getNumber(Ranking ranking) {
        if (!result.containsKey(ranking)) return 0;
        return result.get(ranking);
    }

    public Map<Ranking, Integer> getWinningResult() {
        return result;
    }
}
