package lotto.domain;

import lotto.validate.Validation;

import java.util.List;

public class LottoGame {
    private static final int VALID_LOTTO_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoGame(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        Validation.validateLengthOfList(winningNumbers, VALID_LOTTO_SIZE);
        Validation.validateDuplicationList(winningNumbers);
        Validation.validateListNumberInRange(winningNumbers, MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER);
    }

    public void validateBonusNumber(int bonusNumber) {
        Validation.validateNumberInRange(bonusNumber, MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER);
        Validation.validateDuplicatedNumberInList(winningNumbers, bonusNumber);
    }
}
