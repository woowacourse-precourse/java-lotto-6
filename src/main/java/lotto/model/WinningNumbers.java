package lotto.model;

public class WinningNumbers {

    private static final String BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복이 되면 안 됩니다,";

    private final WinningNumbersData winningNumbersData;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumbersData winningNumbersData, BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(winningNumbersData, bonusNumber);
        this.winningNumbersData = winningNumbersData;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto lotto) {
        return winningNumbersData.countMatchingNumber(lotto);
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber.getBonusNumber());
    }

    private void validateDuplicateBonusNumber(WinningNumbersData winningNumbersData, BonusNumber bonusNumber) {
        if (winningNumbersData.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }
}
