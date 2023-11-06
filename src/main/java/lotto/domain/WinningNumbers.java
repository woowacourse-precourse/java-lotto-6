package lotto.domain;

import lotto.message.ExceptionMessage;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number > 45 || number < 0)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_OVER_RANGE_WINNING.toString());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ExceptionMessage.IS_DUPLICATED.toString());
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_6_LENGTH_OF_WINNING.toString());
        }
    }

    public void addBonusNumber(BonusNumber bonusNumber) {
        validateWinningNumbersContainsBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbersContainsBonusNumber(BonusNumber bonusNumber) {
        if (bonusNumberAlreadyIncluded(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_DUPLICATED_WITH_WINNING.toString());
        }
    }

    private boolean bonusNumberAlreadyIncluded(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }
}
