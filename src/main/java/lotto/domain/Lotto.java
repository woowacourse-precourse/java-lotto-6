package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.enums.Message;

public class Lotto {
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String SEPARATOR = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicates(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw Message.ERROR_DUPLICATE_NUMBER_MESSAGE.createException();
        }
    }

    private static boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size();
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SEPARATOR, PREFIX, SUFFIX));
    }

    public int calculateSameCount(final Lotto compareLotto) {
        return (int) numbers.stream()
                .filter(compareLotto::contains)
                .count();
    }
}