package lotto.model;

import static lotto.model.constant.ErrorMessage.LOTTO_NUMBER_INVALID_SIZE;
import static lotto.model.constant.ErrorMessage.NUMBER_DUPLICATED;
import static lotto.model.constant.ErrorMessage.NUMBER_INVALID_RANGE;
import static lotto.model.constant.LottoConfig.LOTTO_SIZE;
import static lotto.model.constant.LottoConfig.MAXIMUM_LOTTO_NUMBER;
import static lotto.model.constant.LottoConfig.MINIMUM_LOTTO_NUMBER;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        validateRangeNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int sameNumberCounter(WinningNumbers winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::hasNumberInWinningNumbers).count();
    }

    public boolean hasNumber(Integer number) {
        return this.numbers.contains(number);
    }

    private static boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private static boolean hasDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private static boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (isCorrectSize(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_INVALID_SIZE);
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (hasDuplicated(numbers)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED);
        }
    }

    private void validateRangeNumbers(List<Integer> numbers) {
        if (isValidRange(numbers)) {
            throw new IllegalArgumentException(NUMBER_INVALID_RANGE);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
