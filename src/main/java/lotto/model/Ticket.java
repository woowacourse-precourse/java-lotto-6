package lotto.model;

import java.util.List;

public class Ticket {
    private Lotto lotto;
    private Rank rank;

    public Ticket(Lotto lotto) {
        this.lotto = lotto;
        this.rank = null;
    }

    public List<Integer> getLottoNumbers() {
        return lotto.getNumbers();
    }
}
