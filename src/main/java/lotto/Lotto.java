package lotto;

import java.util.List;
import lotto.exception.lotto.LottoDistinctException;
import lotto.exception.lotto.LottoLengthException;
import lotto.exception.lotto.LottoRangeException;

public class Lotto {
    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateNumbersRange(numbers);
        validateNumbersDistinct(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (!hasProperLength(numbers)) {
            throw new LottoLengthException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (!hasProperRange(numbers)) {
            throw new LottoRangeException();
        }
    }

    private void validateNumbersDistinct(List<Integer> numbers) {
        if (!hasDistinctNumbers(numbers)) {
            throw new LottoDistinctException();
        }
    }

    private boolean hasProperLength(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBERS_SIZE;
    }

    private boolean hasProperRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= MIN_BOUND && number <= MAX_BOUND);
    }

    private boolean hasDistinctNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() == LOTTO_NUMBERS_SIZE;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
