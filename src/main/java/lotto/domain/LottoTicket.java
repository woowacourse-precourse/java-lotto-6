package lotto.domain;

import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;
    private final Lotto lotto;

    public LottoTicket(List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    @Override
    public String toString() {
        return this.lotto.toString();
    }
}
