package lotto.model;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateDistinctBonusNumbers(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctBonusNumbers(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public int numberOfMatched(Lotto lotto) {
        return winningNumbers.match(lotto);
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
