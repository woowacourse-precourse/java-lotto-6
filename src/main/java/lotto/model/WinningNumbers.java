package lotto.model;

public class WinningNumbers {

    private static final String BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복이 되면 안 됩니다,";

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(final Lotto lotto) {
        return winningNumbers.countNumber(lotto);
    }

    public boolean hasBonusNumber(final Lotto lotto) {
        return lotto.contains(bonusNumber.getBonusNumber());
    }

    private void validateDuplicateBonusNumber(final Lotto winningNumbers, final BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }
}
