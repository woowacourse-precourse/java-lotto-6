package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;
    private static final int NUMBERS_RANGE_START = 1;
    private static final int NUMBERS_RANGE_END = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int compareTo(Lotto other) {
        int sameCount = 0;
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            sameCount += getSameCount(other, i);
        }
        return sameCount;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private int getSameCount(Lotto other, int i) {
        if (numbers.contains(other.numbers.get(i))) {
            return 1;
        }
        return 0;
    }

    private boolean isSameNumber(Lotto other, int i) {
        return numbers.get(i) == other.numbers.get(i);
    }

    private void validate(List<Integer> numbers) {
        validateEmpty(numbers);
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumbersRange(numbers);
    }

    private void validateEmpty(List<Integer> numbers) {
        if (numbers.size() == 0 || numbers == null) {
            throw new IllegalArgumentException();
        }
    }


    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (!isNumberBetweenRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumberBetweenRange(int number) {
        return number >= NUMBERS_RANGE_START && number <= NUMBERS_RANGE_END;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
        sb.append("]");
        return sb.toString();
    }
}
