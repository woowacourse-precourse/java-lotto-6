package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberRange(numbers);
        validateDuplicateNumber(numbers);
        validateLottoNumbersSize(numbers);
    }

    private void validateLottoNumberRange(List<Integer> numbers) {

    }

    private void validateDuplicateNumber(List<Integer> numbers) {

    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void sortNumbers(List<Integer> numbers) {}

}
