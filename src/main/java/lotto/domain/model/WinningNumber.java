package lotto.domain.model;

import lotto.domain.validator.Validator;
import lotto.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> regularWinningNumbers;

    public WinningNumber(List<Integer> regularWinningNumbers) {
        validateWinningNumbers(regularWinningNumbers);
        this.regularWinningNumbers = regularWinningNumbers;
    }

    private void validateWinningNumbers(List<Integer> regularWinningNumbers) {
        Validator.validateCountOfNumbers(regularWinningNumbers);
        Validator.validateDuplicateNumbers(regularWinningNumbers);

        for (int number : regularWinningNumbers) {
            Validator.validateNumberInRange(number);
        }
    }

    public void validateBonusNumber(int bonusNumber) {
        Set<Integer> duplicateChecker = new HashSet<>(regularWinningNumbers);

        if (!duplicateChecker.add(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_CONTAIN_BONUS_NUMBER_IN_WINNING_NUMBER.getMessage());
        }
    }

    protected List<Integer> getRegularWinningNumbers() {
        return regularWinningNumbers;
    }

}
