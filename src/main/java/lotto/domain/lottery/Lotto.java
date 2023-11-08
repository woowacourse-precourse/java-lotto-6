package lotto.domain.lottery;

import lotto.domain.prize.Prize;
import lotto.exception.LottoException;

import java.util.List;
import java.util.Objects;

import static lotto.domain.lottery.constants.LottoConstraint.LOTTO_PICK_COUNT;
import static lotto.exception.ErrorMessage.*;

public class Lotto extends NumberChecker {
    private final List<Integer> numbers;

    // Constructor
    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumbersRange(numbers);
        validateDuplicatedList(numbers);

        this.numbers = numbers;
    }

    // Utility Method
    public int countPrizeNumberMatchingCount(Prize prize) {
        return (int) numbers.stream()
                .filter(prize::isPrizeNumber)
                .count();
    }

    public boolean hasBonusNumber(Prize prize) {
        return numbers.stream()
                .anyMatch(prize::isBonusNumber);
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    // Exception Handling Method
    private void validateNumbersRange(List<Integer> numbers) {
        if (areOutOfRange(numbers)) {
            throw LottoException.from(NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (isInvalidPickCount(numbers)) {
            throw LottoException.from(NUMBER_COUNT_INVALID);
        }
    }

    private void validateDuplicatedList(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw LottoException.from(NUMBER_DUPLICATED);
        }
    }

    // Validation Method
    private boolean isInvalidPickCount(List<Integer> numbers) {
        return !Objects.equals(numbers.size(), LOTTO_PICK_COUNT.getValue());
    }

    private boolean isDuplicated(List<Integer> numbers) {
        final int uniqueNumberCount = (int) numbers.stream().distinct().count();

        return !Objects.equals(numbers.size(), uniqueNumberCount);
    }

    // Getter
    public List<Integer> getNumbers() {
        return numbers;
    }
}
