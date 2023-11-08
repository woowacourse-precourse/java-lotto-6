package lotto.domain;

import static lotto.constant.ExceptionMessage.ERROR_DUPLICATE_NUMBERS;
import static lotto.constant.ExceptionMessage.ERROR_LOTTO_NUMBER_RANGE;
import static lotto.constant.ExceptionMessage.ERROR_NOT_NUMBERS_SIZE;
import static lotto.constant.LottoConstant.LOTTO_END_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_START_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        validateLottoNumberRange(numbers);
    }

    protected static void validateNumberRange(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBERS_SIZE);
        }
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);

        if (notDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }
    // TODO: 추가 기능 구현
}
