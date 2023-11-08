package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final Lotto lotto;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}
