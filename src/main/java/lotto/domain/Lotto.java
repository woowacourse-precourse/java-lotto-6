package lotto.domain;

import static lotto.domain.constants.ErrorType.*;
import static lotto.domain.constants.RangeType.PRIZE_NUMBER_MAX_RANGE;
import static lotto.domain.constants.RangeType.PRIZE_NUMBER_MIN_RANGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        validatePrizeNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_IS_NOT_RIGHT.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(CONTAIN_DUPLICATED_NUMBER.getErrorMessage());
        }
    }

    private static void validatePrizeNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < PRIZE_NUMBER_MIN_RANGE.getRange() || number > PRIZE_NUMBER_MAX_RANGE.getRange()) {
                throw new IllegalArgumentException(NUMBER_OVER_MAX_OR_MIN_RANGE.getErrorMessage());
            }
        }
    }
}
