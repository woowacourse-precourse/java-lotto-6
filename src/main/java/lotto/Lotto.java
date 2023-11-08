package lotto;

import java.util.List;

import static lotto.util.Validator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberOfLottoNumbers(numbers);
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
