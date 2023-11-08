package lotto.domain;

public class LottoRound {
    private final Lotto lotto;
    private final int bonus;

    public LottoRound(
            Lotto lotto,
            int bonus
    ) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static LottoRound of(
            Lotto lotto,
            int bonus
    ) {
        return new LottoRound(lotto, bonus);
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public int getBonus() {
        return this.bonus;
    }
}
