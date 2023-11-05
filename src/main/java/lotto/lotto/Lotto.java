package lotto.lotto;

import static lotto.exception.ExceptionMessage.WRONG_LOTTO_NUMBER_SIZE;

import java.util.List;
import lotto.validator.LottoNumberValidator;

class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateEachNumberSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEachNumberSize(List<Integer> numbers) {
        numbers.forEach(number -> {
            LottoNumberValidator.validateNumberIsLottoNumber(number, WRONG_LOTTO_NUMBER_SIZE);
        });
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        LottoNumberValidator.validateDuplicateLottoNumber(numbers);
    }
}
