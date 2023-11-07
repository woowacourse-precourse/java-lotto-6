package lotto.model;

public class WinningLotto {
    private final BonusNumber bonusNumber
    private final Lotto winningLotto;

    public WinningLotto(Lotto lotto, BonusNumber bonus) {
        winningLotto = lotto;
        bonusNumber = bonus;
    }
}
