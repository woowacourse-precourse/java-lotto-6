package lotto.domain;

import lotto.constants.LottoErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    static final int PRICE_PER_LOTTO = 1000;

    private static final int LOTTO_SIX_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLengthNumber(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    private static void validateLengthNumber(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIX_SIZE) {
            throw new IllegalArgumentException(LottoErrorMessage.LENGTH_INVALID.entireMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (isOverRange(numbers)) {
            throw new IllegalArgumentException(LottoErrorMessage.RANGE_INVALID.entireMessage());
        }
    }

    private static boolean isOverRange(List<Integer> numbers) {
        long numberCount = numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .count();
        return numberCount != 0;
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (isDuplication(numbers)) {
            throw new IllegalStateException(LottoErrorMessage.DUPLICATE_INVALID.entireMessage());
        }
    }

    private static boolean isDuplication(List<Integer> numbers) {
        long duplication = numbers.stream()
                .distinct()
                .count();
        return duplication != LOTTO_SIX_SIZE;
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
