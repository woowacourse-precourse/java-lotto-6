package lotto.domain;

import lotto.exception.ExceptionMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_NUMBERS_MINIMUM = 1;
    private static final int LOTTO_NUMBERS_MAXIMUM = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            ExceptionMessage.LOTTO_WRONG_NUMBERS_COUNT.throwIllegalArgumentException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBERS_MINIMUM || number > LOTTO_NUMBERS_MAXIMUM) {
                ExceptionMessage.LOTTO_WRONG_NUMBER_RANGE.throwIllegalArgumentException();
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != numbers.size()) {
            ExceptionMessage.LOTTO_DUPLICATE_NUMBERS.throwIllegalArgumentException();
        }
    }

    public int countMatchingNumbers(LottoWinningNumbers winningNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winningNumbers::containsNumber)
                .count());
    }

    public boolean containsBonusNumber(LottoBonusNumber bonusNumber) {
        return bonusNumber.includesBonusNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
