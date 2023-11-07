package lotto.dto;

import java.util.Collections;
import java.util.List;

public record WinningNumber(List<Integer> numbers) {

    public WinningNumber {
        validateNull(numbers);
        validateNumbersCount(numbers.size());
        for (Integer number : numbers) {
            validateNumbersRange(number);
        }
    }

    private void validateNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersCount(int size) {
        if (size != 6) {
            throw new IllegalArgumentException("");
        }
    }

    private void validateNumbersRange(Integer number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(Integer integer) {
        return numbers.contains(integer);
    }
}
