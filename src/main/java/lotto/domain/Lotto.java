package lotto.domain;

import static java.util.Collections.sort;

import java.util.List;
import java.util.function.Predicate;

public class Lotto implements Comparable<Lotto> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = makeAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (!checkSize(numbers) || !checkUnique(numbers) || !checkRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(Lotto other) {
        Long sameCount = this.numbers.stream()
                .filter(number -> other.numbers.stream().anyMatch(Predicate.isEqual(number))).count();
        return sameCount.intValue();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private List<Integer> makeAscending(List<Integer> numbers) {
        sort(numbers);
        return numbers;
    }

    private boolean checkSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean checkUnique(List<Integer> numbers) {
        List<Integer> unique = numbers.stream().distinct().toList();
        return numbers.size() == unique.size();
    }

    private boolean checkRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }
}
