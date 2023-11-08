package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorMessage;

public class Lotto {
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 45;
    public static final int LOTTO_NUMBER_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isCorrectSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_WRONG_SIZE.getMessage());
        }
        if (!isInRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE.getMessage());
        }
        if (!isUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_UNIQUE.getMessage());
        }
    }

    private boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_LENGTH;
    }

    private boolean isInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_RANGE_MIN || number > LOTTO_NUMBER_RANGE_MAX) {
                return false;
            }
        }
        return true;
    }

    private boolean isUniqueNumbers(List<Integer> numbers) {
        boolean[] isContained = new boolean[LOTTO_NUMBER_RANGE_MAX + 1];
        for (Integer number : numbers) {
            if (isContained[number]) {
                return false;
            }
            isContained[number] = true;
        }
        return true;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
