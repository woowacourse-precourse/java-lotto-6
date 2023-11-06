package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.view.InputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctNumber = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != distinctNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }


}
