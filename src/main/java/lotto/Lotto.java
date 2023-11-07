package lotto;

import java.util.List;
import lotto.domain.Rank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = getSortedNumbers(numbers);
    }

    private List<Integer> getSortedNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateRange(final List<Integer> numbers) {
        boolean notMatchRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (notMatchRange) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (isNotEqual(distinctCount, numbers.size())) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotEqual(final long distinctCount, final int lottoNumbersCount) {
        return distinctCount != lottoNumbersCount;
    }

    private boolean contains(final int other) {
        return numbers.stream()
                .anyMatch(number -> number.equals(other));
    }

    private long compare(final Lotto other) {
        return numbers.stream()
                .filter(other::contains)
                .count();
    }

    public Rank calculateRank(final Lotto other, final int bonusNumber) {
        if (other.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        long matchCount = compare(other);
        boolean isBonus = contains(bonusNumber);
        return Rank.findBy(matchCount, isBonus);
    }
}
