package lotto.domain;

import java.util.List;

public class Ticket {

    private final Lotto lotto;
    public Ticket(Lotto lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}
