package domain;

import static domain.LottoInfoNumbers.*;

import java.util.List;

public class LottoValidation {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoValidation(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumbers(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        Validations.validateLengthOfList(winningNumbers, LOTTO_TOTAL_NUMBER);
        Validations.validateDuplicate(winningNumbers);
        Validations.validateListWithinRange(winningNumbers);
    }

    public void validateBonusNumbers(int bonusNumber) {
        Validations.validateNumberWithinRange(bonusNumber);
        Validations.validateDuplicateElementInList(winningNumbers, bonusNumber);
    }


}
