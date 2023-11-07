package lotto.domain;

import lotto.exception.DuplicatedWinningNumbersAndBonusNumberException;
import lotto.exception.DuplicatedNumberException;
import lotto.exception.InvalidNumbersLengthException;
import lotto.exception.OverRangeWinningNumbersException;
import lotto.message.ExceptionMessage;
import lotto.message.NumberUsedLotto;

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
        if (numbers.stream()
                .anyMatch(number -> number > NumberUsedLotto.MAX_LANGE.getNumber()
                        || number < NumberUsedLotto.MIN_RANGE.getNumber())) {
            String message = ExceptionMessage.IS_OVER_RANGE_WINNING.toString();
            throw new OverRangeWinningNumbersException(message);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            String message = ExceptionMessage.IS_DUPLICATED.toString();
            throw new DuplicatedNumberException(message);
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != NumberUsedLotto.NUMBERS_SIZE.getNumber()) {
            String message = ExceptionMessage.IS_NOT_6_LENGTH_OF_WINNING.toString();
            throw new InvalidNumbersLengthException(message);
        }
    }

    public void addBonusNumber(BonusNumber bonusNumber) {
        validateWinningNumbersContainsBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbersContainsBonusNumber(BonusNumber bonusNumber) throws DuplicatedWinningNumbersAndBonusNumberException {
        if (bonusNumberAlreadyIncluded(bonusNumber)) {
            String message = ExceptionMessage.IS_DUPLICATED_WITH_WINNING.toString();
            throw new DuplicatedWinningNumbersAndBonusNumberException(message);
        }
    }

    private boolean bonusNumberAlreadyIncluded(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public boolean hasBonusNumber(List<Integer> lotto) {
        return lotto.contains(bonusNumber.getNumber());
    }
}
