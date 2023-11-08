package lotto.domain;

import static lotto.constant.ExceptionMessage.*;
import static lotto.constant.LottoConstant.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinnerNumbers {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinnerNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        validDuplicateNumber(numbers);
        validateNumbersRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateNumbers(numbers);
        validateNumberRange(bonusNumber);
        validateBonusNumberInNumbers(numbers, bonusNumber);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBERS_SIZE);
        }
    }

    private static void validDuplicateNumber(List<Integer> numbers) {

        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);

        if (notDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }

    private void validateBonusNumberInNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_IN_WINNER_NUMBERS);
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }
}
