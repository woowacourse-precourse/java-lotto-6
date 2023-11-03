package lotto.domain;

import static lotto.constants.ErrorConstants.ERROR_LOTTO_NUMBER_DUPLICATE;
import static lotto.constants.ErrorConstants.ERROR_LOTTO_NUMBER_RANGE_OVER;
import static lotto.constants.ErrorConstants.ERROR_LOTTO_NUMBER_SIZE;

import java.util.Collections;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumberSizeCheck(numbers);
        DuplicateNumberCheck(numbers);
        NumberRangeCheck(numbers);
    }

    private void NumberSizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw LottoException.of(ERROR_LOTTO_NUMBER_SIZE);
        }
    }

    private void DuplicateNumberCheck(List<Integer> numbers) {
        long count = numbers
                .stream()
                .distinct()
                .count();

        if (numbers.size() != count) {
            throw LottoException.of(ERROR_LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void NumberRangeCheck(List<Integer> numbers) {
        boolean overRangeResult = numbers.stream().anyMatch(num -> num <= 0 || num > 45);
        if (overRangeResult) {
            throw LottoException.of(ERROR_LOTTO_NUMBER_RANGE_OVER);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean isContainsNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
