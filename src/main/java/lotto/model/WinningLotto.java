package lotto.model;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        validateRangeOverBonusNumber(bonusNumber);
        validateDuplicateBonusNumber(winningLotto, bonusNumber);
    }

    private void validateRangeOverBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isNumberContain(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
