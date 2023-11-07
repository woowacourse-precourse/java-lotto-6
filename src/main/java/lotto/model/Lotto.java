package lotto.model;

import static lotto.model.ErrorMessage.LOTTO_DUPLICATE_ERROR;
import static lotto.model.ErrorMessage.LOTTO_RANGE_ERROR;
import static lotto.model.ErrorMessage.LOTTO_WRONG_SIZE_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public LottoResult calculateResult(WinningLotto winningLotto) {
        return LottoResult.compareLottoNums(numbers, winningLotto);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        isCorrectSize(numbers);
        isDuplicate(numbers);
        isInRangeNumbers(numbers);
    }

    private void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_WRONG_SIZE_ERROR.getMessage());
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> noDupBucket = new HashSet<>(numbers);
        if (noDupBucket.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR.getMessage());
        }
    }

    private void isInRangeNumbers(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getMessage());
            }
        });
    }
}
