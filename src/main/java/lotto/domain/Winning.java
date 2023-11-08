package lotto.domain;

public class Winning {
    private final Lotto lotto;
    private final Bonus bonus;

    public Winning(final Lotto lotto, final Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int getMatchedCount(final Lotto other) {
        return lotto.getMatchedCount(other);
    }

    public boolean containBonusNumber(final Lotto other) {
        return bonus.containNumber(other);
    }
}
