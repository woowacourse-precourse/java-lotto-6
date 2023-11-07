package lotto.domain;

public class LottoDraw {
    private final Lotto lotto;
    private final Bonus bonus;

    private LottoDraw(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static LottoDraw of(Lotto lotto, Bonus bonus) {
        return new LottoDraw(lotto, bonus);
    }
}
