package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final Lotto lotto;

    public static int PRICE = 1000;

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
