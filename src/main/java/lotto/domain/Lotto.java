package lotto.domain;

import lotto.validation.LottoNumberValidator;

import java.util.List;

import static lotto.message.ErrorMessage.ERROR_MESSAGE_HEAD;
import static lotto.message.ErrorMessage.INVALID_NUMBER_SIZE_EXCEPTION;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + INVALID_NUMBER_SIZE_EXCEPTION + numbers.size());
        }

        LottoNumberValidator.validateDuplicateNumbers(numbers);
        LottoNumberValidator.validateNumberRange(numbers);
        LottoNumberValidator.validateNumbersOrder(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
