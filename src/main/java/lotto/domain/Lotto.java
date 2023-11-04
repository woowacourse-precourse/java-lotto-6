package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.validator.LottoNumberValidator;

import java.util.List;

import static lotto.constants.LottoNumberConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }

        LottoNumberValidator.validateDuplicate(numbers);
        LottoNumberValidator.validateNumbersInRange(numbers);
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(List<Integer> comparingNumbers) {
        return (int) numbers.stream()
                .filter(comparingNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
