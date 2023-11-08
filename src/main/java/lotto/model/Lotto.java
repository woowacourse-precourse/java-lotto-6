package lotto.model;

import java.util.List;

import static lotto.validator.Validation.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkInRange(numbers);
        checkDuplication(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
