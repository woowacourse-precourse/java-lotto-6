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
    public Lotto(final List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumbersRange(numbers);
        validateDuplicatedList(numbers);

        this.numbers = numbers;
    }

    // Utility Method
    public int countPrizeNumberMatchingCount(final Prize prize) {
        return (int) numbers.stream()
                .filter(prize::isPrizeNumber)
                .count();
    }

    public boolean hasBonusNumber(final Prize prize) {
        return numbers.stream()
                .anyMatch(prize::isBonusNumber);
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    // Exception Handling Method
    private void validateNumbersRange(final List<Integer> numbers) {
        if (areOutOfRange(numbers)) {
            throw LottoException.from(NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateNumberCount(final List<Integer> numbers) {
        if (isInvalidPickCount(numbers)) {
            throw LottoException.from(NUMBER_COUNT_INVALID);
        }
    }

    private void validateDuplicatedList(final List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw LottoException.from(NUMBER_DUPLICATED);
        }
    }

    // Validation Method
    private boolean isInvalidPickCount(final List<Integer> numbers) {
        return !Objects.equals(numbers.size(), LOTTO_PICK_COUNT.getValue());
    }

    private boolean isDuplicated(final List<Integer> numbers) {
        final int uniqueNumberCount = (int) numbers.stream().distinct().count();

        return !Objects.equals(numbers.size(), uniqueNumberCount);
    }

    // Getter
    public List<Integer> getNumbers() {
        return numbers;
    }
}
