package lotto.domain;

public class NumberChecker {
    private final Lotto winningLotto;
    private final Bonus bonus;

    private NumberChecker(Lotto winningLotto, Bonus bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public static NumberChecker from(Lotto winningLotto, Bonus bonus) {
        return new NumberChecker(winningLotto, bonus);
    }

}
