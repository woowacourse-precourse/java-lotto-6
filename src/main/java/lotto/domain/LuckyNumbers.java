package lotto.domain;

import java.util.List;
import lotto.service.UserNumbersValidateEnum;

public class LuckyNumbers {
    private int bonusNumber;
    private List<Integer> winningNumbers;

    public LuckyNumbers(int bonusNumber, List<Integer> winningNumbers) {
        duplicateValidate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    private void duplicateValidate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(UserNumbersValidateEnum.DUPLICATE_NUMBERS_BONUS_ERROR.get());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
