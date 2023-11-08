package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.util.Validator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }

        validateLottoNumberDuplicate(numbers);
        validateRangeOfNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
