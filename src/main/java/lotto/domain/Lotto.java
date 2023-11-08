package lotto.domain;

import static lotto.constants.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.constants.ErrorMessage.INVALID_SIZE;
import static lotto.constants.ErrorMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constants.LottoOption.END_LOTTO_NUMBER;
import static lotto.constants.LottoOption.LOTTO_COUNT;
import static lotto.constants.LottoOption.START_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
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
        if (numbers.size() != LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(String.format(INVALID_SIZE.getMessage(), LOTTO_COUNT.getValue()));
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < START_LOTTO_NUMBER.getValue() || number > END_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(
                        String.format(NUMBER_OUT_OF_RANGE.getMessage(), START_LOTTO_NUMBER.getValue(),
                                END_LOTTO_NUMBER.getValue()));
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
