package lotto.domain;

import java.util.List;
import lotto.exception.lotto.DuplicateNumberException;
import lotto.exception.lotto.IllegalNumberCountException;
import lotto.exception.lotto.OutOfRangeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicateNumber(numbers);
        validateOutOfRangeNumber(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalNumberCountException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount < numbers.size()) {
            throw new DuplicateNumberException();
        }
    }

    private void validateOutOfRangeNumber(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || 45 < number) {
                throw new OutOfRangeException();
            }
        });
    }

}
