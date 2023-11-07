package lotto.domain;

import static lotto.utils.Validator.validateDuplication;
import static lotto.utils.Validator.validateSize;

import java.util.List;
import lotto.utils.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        numbers.forEach(Validator::validateFittingInRange);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> sortNumbers() {
        return this.numbers.stream()
                .sorted()
                .toList();
    }
}