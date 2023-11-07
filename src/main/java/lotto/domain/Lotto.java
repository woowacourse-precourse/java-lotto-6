package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.utils.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;
    private static final int NUMBERS_SIZE_MIN = 1;
    private static final int NUMBERS_SIZE_MAX = 45;
    private static final int NUMBERS_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidateLottoNumbersRange(numbers);
        isValidateLottoNumbersDuplicate(numbers);
        isValidLottoNumbersSize(numbers);
    }

    private static void isValidLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_SIX_SIZE.getMessage());
        }
    }

    private static void isValidateLottoNumbersRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < NUMBERS_SIZE_MIN || number > NUMBERS_SIZE_MAX) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE_RANGE_ERROR.getMessage());
            }
        });
    }

    private static void isValidateLottoNumbersDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
