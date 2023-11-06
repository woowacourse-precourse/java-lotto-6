package lotto.domain;

import java.util.List;
import lotto.exception.lottonumbersexception.InsufficientNumbersCountException;
import lotto.exception.lottonumbersexception.NonDuplicateNumbersException;
import lotto.exception.lottonumbersexception.OutOfNumbersRangeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InsufficientNumbersCountException();
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new NonDuplicateNumbersException();
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new OutOfNumbersRangeException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
