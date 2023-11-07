package lotto.domain;

import java.util.List;
import java.util.Set;

import static lotto.view.LottoErrorMessage.*;

public class Lotto {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplication(numbers);
        validateSize(numbers);
        validateRange(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(
                number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
        ) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATION.getMessage());
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public String getInformation() {
        return numbers.toString();
    }
}
