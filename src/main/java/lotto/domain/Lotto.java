package lotto.domain;

import java.util.List;
import lotto.domain.util.Validation;
import lotto.exception.ErrorMessage;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_LOTTO_NUMBERS_COUNT.getMessage());
        }
        if (!numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        Validation.validateLottoNumbers(numbers);
    }

}
