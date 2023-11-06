package lotto.domain;

import lotto.domain.ticket.Bonus;
import lotto.domain.ticket.Lotto;

import java.util.List;

public class Ticket {
    private Lotto lotto;
    private Bonus bonus;

    public Ticket(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public List<Integer> getLotto() {
        return lotto.getNumbers();
    }
}
