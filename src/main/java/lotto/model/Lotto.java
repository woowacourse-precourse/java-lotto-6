package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.constant.LottoGameNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = sorted(numbers);
    }

    public int match(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        if (Objects.isNull(numbers)
                || numbers.size() != LottoGameNumber.COUNT
                || isOutOfRange(numbers)
                || hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return number < LottoGameNumber.MINIMUM || number > LottoGameNumber.MAXIMUM;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        long uniqueCounts = numbers.stream()
                .distinct()
                .count();

        return numbers.size() != uniqueCounts;
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
