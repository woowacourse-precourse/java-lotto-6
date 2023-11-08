package lotto.domain;

import java.util.List;
import lotto.view.input.error.InputError;
import lotto.view.input.error.InputIllegalArgumentException;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_LENGTH = 6;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateNumbersInRange(numbers);
    }

    private List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> getLottoNumbers() {
        return getNumbers();
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new InputIllegalArgumentException(InputError.DUPLICATED);
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new InputIllegalArgumentException(InputError.NOT_SUITABLE_LENGTH, LOTTO_LENGTH);
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        if (!isNumbersInRange(numbers)) {
            throw new InputIllegalArgumentException(InputError.NOT_IN_RANGE_NUMBER);
        }
    }

    public static boolean isNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= START_RANGE && number <= END_RANGE);
    }

    private boolean hasDuplicate(List<Integer> numbers) {

        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    public void validateContainsNumber(int bonusNumber) {
        boolean isContainsNumber = this.numbers.stream()
                .anyMatch(number -> number == bonusNumber);

        if (isContainsNumber) {
            throw new InputIllegalArgumentException(InputError.DUPLICATED);
        }
    }
}
