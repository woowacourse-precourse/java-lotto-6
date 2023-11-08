package lotto.domain.number;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String INVALID_SIZE = "로또 번호의 개수는 6개여야 합니다.";
    private static final String DUPLICATES_FOUND = "로또 번호에는 중복된 숫자가 없어야 합니다.";
    private static final int SIZE = 6;
    private final Set<Number> numbers;

    public Lotto(Set<Number> numbers) {
        validateSize(numbers);
        this.numbers = Set.copyOf(numbers);
    }

    public static Lotto of(List<Number> numbers) {
        validateSize(numbers);
        validateNoDuplicates(numbers);
        Set<Number> numberSet = new HashSet<>(numbers);
        return new Lotto(numberSet);
    }

    private static void validateSize(Collection<Number> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    private static void validateNoDuplicates(List<Number> numbers) {
        Set<Number> numberSet = new HashSet<>(numbers);
        if (numberSet.size() < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATES_FOUND);
        }
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public int countMatches(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Number> createSortedNumbers() {
        return numbers.stream()
                .sorted(Comparator.comparing(Number::getValue))
                .toList();
    }
}
