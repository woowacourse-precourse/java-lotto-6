package lotto.entity;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.utilTest.Validator.validateLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumber = numbers.stream().sorted().collect(Collectors.toList());

        this.numbers = sortedNumber;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
