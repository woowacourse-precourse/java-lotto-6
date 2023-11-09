package lotto.domain.model;

import lotto.constant.message.ErrorMessage;
import lotto.domain.validator.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> regularWinningNumbers;

    public WinningNumber(final List<Integer> regularWinningNumbers) {
        validateWinningNumbers(regularWinningNumbers);
        this.regularWinningNumbers = regularWinningNumbers;
    }

    private void validateWinningNumbers(final List<Integer> regularWinningNumbers) {
        Validator.validateCountOfNumbers(regularWinningNumbers);
        Validator.validateDuplicateNumbers(regularWinningNumbers);

        for (int number : regularWinningNumbers) {
            Validator.validateNumberInRange(number);
        }
    }

    protected List<Integer> getRegularWinningNumbers() {
        return regularWinningNumbers;
    }

    public BonusNumber createBonusNumber(final int bonusNumber) {
        validateBonusNumber(bonusNumber);
        return new BonusNumber(bonusNumber);
    }

    public void validateBonusNumber(final int bonusNumber) {
        Set<Integer> duplicateChecker = new HashSet<>(regularWinningNumbers);

        if (!duplicateChecker.add(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CONTAIN_BONUS_NUMBER_IN_WINNING_NUMBER);
        }
    }

}
