package lotto.domain;

public class LottoAnswer {
    private final Lotto lotto;
    private final int bonus;

    public LottoAnswer(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }
}
