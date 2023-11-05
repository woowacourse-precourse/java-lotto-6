package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateNumbersException;
import lotto.exception.InvalidLottoSizeException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String SEPARATOR = ",";

    private final List<Number> numbers;

    private Lotto(final List<Number> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto fromInput(final String numbers) {
        List<Number> number = Arrays.stream(numbers.split(SEPARATOR))
                .map(Number::from)
                .toList();

        return new Lotto(number);
    }

    public static Lotto fromNumbers(final List<Integer> numbers) {
        List<Number> number = numbers.stream()
                .map(Number::from)
                .toList();

        return new Lotto(number);
    }

    private static void validateLotto(final List<Number> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
    }

    private static void validateSize(final List<Number> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoSizeException();
        }
    }

    private static void validateDuplicates(final List<Number> numbers) {
        if (hasDuplicates(numbers)) {
            throw new DuplicateNumbersException();
        }
    }

    private static boolean hasDuplicates(final List<Number> numbers) {
        Set<Number> duplicates = new HashSet<>(numbers);
        return duplicates.size() != numbers.size();
    }

    public boolean contains(final Number number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(final List<Number> lottoNumber) {
        return (int) lottoNumber.stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Number> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
