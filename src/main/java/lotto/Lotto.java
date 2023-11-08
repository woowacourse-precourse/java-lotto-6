package lotto;

import java.util.List;

import static lotto.ValidateService.*;

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
        validateAuthorizedLength(numbers);
        validateDuplicatedNums(numbers);
        validateNumbersInRange(numbers);
    }
}
