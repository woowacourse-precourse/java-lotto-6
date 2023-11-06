package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicatedLottoNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLottoNumberDuplicatedAndThrowException(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    private void checkLottoNumberDuplicatedAndThrowException(List<Integer> numbers)
            throws IllegalArgumentException {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new DuplicatedLottoNumberException();
        }
    }
}
