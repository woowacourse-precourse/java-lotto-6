package lotto.domain;

public class GuessLotto {

    private final Lotto lotto;
    private final int bonus;

    public GuessLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
