package lotto.domain;

import static lotto.constants.Error.DUPLICATION_ERROR;
import static lotto.constants.Error.SIZE_ERROR;
import static lotto.constants.Value.LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean checkContainNumber(int number) {
        return numbers.contains(number);
    }

    public int countContainNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.get()) {
            throw new IllegalArgumentException(SIZE_ERROR.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
    }
}
