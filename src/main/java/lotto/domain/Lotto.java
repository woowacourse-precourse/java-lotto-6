package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.domain.constant.ExceptionMessage.*;
import static lotto.domain.constant.RangeConstant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> unmodifiableNumbers = Collections
                .unmodifiableList(numbers);

        validate(unmodifiableNumbers);

        this.numbers = unmodifiableNumbers;
    }

    public int countingMatchNumbers(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(number -> lotto.containsNumber(number))
                .count();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        numbers.stream()
                .forEach(number -> validateLottoRange(number));
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE_NUM.getNumber()) {
            throw new IllegalArgumentException(INPUT_LOTTO_SIZE.getErrorMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();

        if (numbers.size() != count) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getErrorMessage());
        }
    }

    protected static void validateLottoRange(int number) {
        if (number < START_NUM.getNumber() || number > END_NUM.getNumber()) {
            throw new IllegalArgumentException(INVALID_RANGE_LOTTO_NUMBER.getErrorMessage());
        }
    }

}
