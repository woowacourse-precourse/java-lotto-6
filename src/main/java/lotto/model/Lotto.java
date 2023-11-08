package lotto.model;

import java.util.List;
import lotto.constants.ErrorMessages;
import lotto.constants.LottoNumberLimits;

public class Lotto {
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        checkNumbersSize(numbers);
        checkForDuplicates(numbers);
        checkNumberRange(numbers);
    }

    private void checkNumberRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < LottoNumberLimits.MIN_NUMBER || number > LottoNumberLimits.MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private void checkForDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.NON_DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private void checkNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int matchNumbers(Lotto winningLotto) {
        return (int) winningLotto.getNumbers()
                .stream()
                .filter(numbers::contains)
                .count();
    }

}
