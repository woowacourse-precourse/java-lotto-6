package lotto.model;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumberRange(bonusNumber);
        validateDistinctBonusNumbers(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctBonusNumbers(int bonusNumber) {
        if (winningNumbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public int checkNumbers(Lotto lotto) {
        return winningNumbers.match(lotto);
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.containsNumber(bonusNumber);
    }
}
