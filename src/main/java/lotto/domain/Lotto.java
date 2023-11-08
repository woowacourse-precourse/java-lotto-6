package lotto.domain;

import static lotto.util.Validator.validateDuplicate;
import static lotto.util.Validator.validateRangeOfNumbers;

import java.util.List;

public class Lotto {
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 6개 번호를 입력해주세요.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRangeOfNumbers(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }
}
