package lotto;

import java.util.Map;

public class Winning {
    private final Map<Ranking, Integer> result;

    Winning(Tickets tickets, Lotto lotto, Bonus bonus) {
        result = tickets.drawAllTickets(lotto, bonus);
    }

    int getFirstNumber() {
        return result.get(Ranking.FIRST);
    }

    int getSecondNumber() {
        return result.get(Ranking.SECOND);
    }

    int getThirdNumber() {
        return result.get(Ranking.THIRD);
    }

    int getFourthNumber() {
        return result.get(Ranking.FOURTH);
    }

    int getFifthNumber() {
        return result.get(Ranking.FIFTH);
    }
}
