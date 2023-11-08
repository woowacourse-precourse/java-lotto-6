package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        InputValidator.validateLottoLength(numbers);
        InputValidator.validateNoDuplicates(numbers);

        for (int number: numbers) {
            InputValidator.validateIsLottoNumber(number);
        }
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
