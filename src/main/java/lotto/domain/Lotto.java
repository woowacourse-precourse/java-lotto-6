package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateNumbersException;
import lotto.exception.InvalidLottoSizeException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    private Lotto(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Lotto fromStringList(final List<String> numbers) {
        validate(numbers);

        List<Number> number = numbers.stream()
                .map(Number::from)
                .toList();

        return new Lotto(number);
    }

    public static Lotto fromIntegerList(final List<Integer> numbers) {
        validate(numbers);

        List<Number> number = numbers.stream()
                .map(Number::from)
                .toList();

        return new Lotto(number);
    }

    private static void validate(final List<?> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
    }

    private static void validateSize(final List<?> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoSizeException();
        }
    }

    private static void validateDuplicates(final List<?> numbers) {
        if (hasDuplicates(numbers)) {
            throw new DuplicateNumbersException();
        }
    }

    private static boolean hasDuplicates(final List<?> numbers) {
        Set<?> duplicates = new HashSet<>(numbers);
        return duplicates.size() != numbers.size();
    }

    public boolean contains(final Number number) {
        return numbers.contains(number);
    }

    public int getSameCount(final List<Number> lottoNumber) {
        return (int) lottoNumber.stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
