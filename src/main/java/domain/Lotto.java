package domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoOverSize(numbers);
        validateLottoNumberIsDuplicated(numbers);
        validateEachLottoNumberExceededSize(numbers);
        this.numbers = numbers;
    }

    private void validateLottoOverSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumberIsDuplicated(List<Integer> numbers) {
        if (new HashSet(numbers).size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEachLottoNumberExceededSize(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
