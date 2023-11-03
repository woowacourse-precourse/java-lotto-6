package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateNumbersException;
import lotto.exception.InvalidSizeException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    private Lotto(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final List<String> numbers) {
        validate(numbers);

        List<Number> number = numbers.stream()
                .map(Number::from)
                .toList();

        return new Lotto(number);
    }

    private static void validate(final List<String> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
    }

    private static void validateSize(final List<String> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidSizeException();
        }
    }

    private static void validateDuplicates(final List<String> numbers) {
        if (hasDuplicates(numbers)) {
            throw new DuplicateNumbersException();
        }
    }

    private static boolean hasDuplicates(final List<String> numbers) {
        Set<String> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
