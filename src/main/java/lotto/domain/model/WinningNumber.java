package lotto.domain.model;

import lotto.domain.validator.Validator;

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

    public void validateAlreadyHaveNumber(int bonusNumber) {
        Set<Integer> duplicateChecker = new HashSet<>(regularWinningNumbers);

        if (!duplicateChecker.add(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 포함되지 않은 숫자를 입력해야 합니다.");
        }
    }

    protected List<Integer> getRegularWinningNumbers() {
        return regularWinningNumbers;
    }

}
