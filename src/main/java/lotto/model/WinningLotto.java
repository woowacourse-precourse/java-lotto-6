package lotto.model;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(winningLotto, bonusNumber);
        this.lotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.isNumberContain(bonusNumber.getNumber())) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
