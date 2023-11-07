package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, BonusNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
