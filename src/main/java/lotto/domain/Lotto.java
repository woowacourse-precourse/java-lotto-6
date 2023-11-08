package lotto.domain;

import static lotto.constants.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.constants.ErrorMessage.INVALID_SIZE;
import static lotto.constants.ErrorMessage.NUMBER_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSizeExact(numbers);
        validateNoDuplicate(numbers);
        validateNumbersInRange(numbers);

        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        return new Lotto(numbers);
    }

    private void validateSizeExact(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(String.format(INVALID_SIZE.getMessage(), LOTTO_COUNT));
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < START_LOTTO_NUMBER || number > END_LOTTO_NUMBER) {
                throw new IllegalArgumentException(
                        String.format(NUMBER_OUT_OF_RANGE.getMessage(), START_LOTTO_NUMBER, END_LOTTO_NUMBER));
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
