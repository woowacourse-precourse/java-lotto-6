package lotto.domain;

import lotto.constraints.ErrorMessage;

import java.util.List;

public class WinningInfo {
    private final List<Integer> winningNumbers;

    private final int bonusNumber;

    public WinningInfo(List<Integer> numbers, int bonusNumber) {
        LottoValidator.validateDuplicateNumber(numbers);
        LottoValidator.validateSize(numbers);
        LottoValidator.validateNumbersRange(numbers);
        LottoValidator.validateNumberRange(bonusNumber);
        validateBonusNumber(numbers, bonusNumber);
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
