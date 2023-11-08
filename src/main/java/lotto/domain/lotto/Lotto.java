package lotto.domain.lotto;

import lotto.domain.result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validRange(numbers);
        validSize(numbers);
        validDuplicate(numbers);
    }

    private void validRange(List<Integer> numbers) {
        boolean outOfRange = numbers.stream()
                .anyMatch(i -> i < 1 || i > 45);

        if (outOfRange) {
            throw new IllegalArgumentException();
        }
    }

    private void validSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validDuplicate(List<Integer> numbers) {
        long duplicateSize = numbers.stream()
                .distinct()
                .count();

        if (numbers.size() != duplicateSize) {
            throw new IllegalArgumentException();
        }
    }

    public Result compare(Lotto lotto, int bonus) {
        long count = findAccordCount(lotto);

        boolean isContainsBonus = isContainsBonus(bonus);

        return new Result(count, isContainsBonus);
    }

    private long findAccordCount(Lotto lotto) {
        return lotto.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public boolean isContainsBonus(int bonus) {
        return this.numbers.contains(bonus);
    }

    public String printNumber() {
        return "[" + numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
