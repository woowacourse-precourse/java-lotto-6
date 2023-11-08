package lotto.domain;

import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;
    private final Lotto lotto;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}
