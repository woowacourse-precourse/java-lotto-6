package lotto.domain;

import java.util.List;
import lotto.service.UserNumbersValidateStatus;

public class LuckyNumbers {
    private int bonusNumber;
    private List<Integer> winningNumbers;

    public LuckyNumbers(int bonusNumber, List<Integer> winningNumbers) {
        try {
            duplicateValidate(bonusNumber, winningNumbers);
            this.bonusNumber = bonusNumber;
            this.winningNumbers = winningNumbers;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    private void duplicateValidate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalStateException(UserNumbersValidateStatus.DUPLICATE_NUMBERS_BONUS_ERROR.get());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
