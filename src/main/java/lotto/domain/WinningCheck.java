package lotto.domain;

public class WinningCheck {
    private final Lotto lotto;
    private final int bonusball;
    public WinningCheck(Lotto lotto, int bonusball) {
        this.lotto = lotto;
        this.bonusball = bonusball;
    }
}
