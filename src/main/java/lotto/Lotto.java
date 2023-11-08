package lotto;

import static lotto.exception.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.HashSet;
import java.util.List;
import lotto.exception.LottoGameException;

public class Lotto {
    protected static final int NUMBER_START = 1;
    protected static final int NUMBER_END = 45;
    private static final int VALID_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateNumberNotDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != VALID_NUMBER_COUNT) {
            throw LottoGameException.of(INVALID_LOTTO_NUMBER_COUNT);
        }
    }


    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < NUMBER_START) {
                throw LottoGameException.of(INVALID_LOTTO_NUMBER_RANGE);
            }
            if (number > NUMBER_END) {
                throw LottoGameException.of(INVALID_LOTTO_NUMBER_RANGE);
            }
        });
    }

    private void validateNumberNotDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);

        if (numberSet.size() != VALID_NUMBER_COUNT) {
            throw LottoGameException.of(DUPLICATE_LOTTO_NUMBER);
        }
    }

    public List<Integer> getNumberList() {
        return numbers;
    }
}
