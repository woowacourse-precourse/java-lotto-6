package lotto;

import java.util.HashSet;
import java.util.List;
import lotto.model.WinningNumber;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> numbers;
    private final WinningNumber winningNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.winningNumber = new WinningNumber(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize();
        checkIsDuplicated();
        validateRange();
    }

    private void validateSize() {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIsDuplicated() {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange() {
        for (Integer number : numbers) {
            checkIsInValidRange(number);
        }
    }

    private void checkIsInValidRange(int number) {
        if (number < LOTTO_NUMBER_MIN || LOTTO_NUMBER_MAX < number) {
            throw new IllegalArgumentException();
        }
    }
}
