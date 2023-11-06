package lotto.domain;

import java.util.List;
import lotto.utils.Validation;

public record LottoData(List<Integer> winningNumbers, int bonusNumber) {

    public LottoData(List<Integer> winningNumbers, int bonusNumber) {
        validatewinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validatewinningNumbers(List<Integer> winningNumbers) {
        Validation.validateListNumberCount(winningNumbers, 6);
        Validation.validateListNumberInRange(winningNumbers, 1, 45);
        Validation.validateListNumberNotDuplicated(winningNumbers);
    }

    private void validateBonusNumber(int bonusNumber) {
        Validation.validateNumberInRange(bonusNumber, 1, 45);
        Validation.validateBonusNumberNotInWinningNumber(bonusNumber, winningNumbers);
    }
}
