package lotto.validation;

import lotto.view.ErrorView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidation {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_START_NUMBER || number > LOTTO_LAST_NUMBER)) {
            throw new IllegalArgumentException(ErrorView.getRangeErrorMessage());
        }
    }

    public static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorView.getDuplicateErrorMessage());
        }
    }

    public static void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorView.getLengthErrorMessage());
        }
    }
}
