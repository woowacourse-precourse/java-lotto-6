package lotto.model;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateDistinctBonusNumbers(bonusNumber);
    }

    private void validateDistinctBonusNumbers(int bonusNumber) {
        if (winningNumbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int checkNumbers(Lotto lotto) {
        return winningNumbers.match(lotto);
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.containsNumber(bonusNumber);
    }
}
