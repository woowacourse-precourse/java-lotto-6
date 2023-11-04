package lotto.domain;

import lotto.constraints.ErrorMessage;

import java.util.List;

public class WinningInfo {
    private final List<Integer> winningNumbers;

    private final int bonusNumber;

    private WinningInfo(List<Integer> numbers, int bonusNumber) {
        LottoValidator.validateDuplicateNumber(numbers);
        LottoValidator.validateSize(numbers);
        LottoValidator.validateNumbersRange(numbers);
        LottoValidator.validateNumberRange(bonusNumber);
        validateBonusNumber(numbers, bonusNumber);
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningInfo from(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningInfo(winningNumbers, bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
