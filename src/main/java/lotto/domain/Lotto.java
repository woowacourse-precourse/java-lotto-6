package lotto.domain;

import static java.util.Collections.sort;
import static lotto.domain.constant.ErrorMessages.NOT_UNIQUE;
import static lotto.domain.constant.ErrorMessages.NUMBER_OF_LOTTO;
import static lotto.domain.constant.ErrorMessages.RANGE_NUMBER;
import static lotto.domain.constant.Range.LOTTO_NUMBER_LOWER_LIMIT;
import static lotto.domain.constant.Range.LOTTO_NUMBER_UPPER_LIMIT;
import static lotto.domain.constant.Range.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lotto implements Comparable<Lotto> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = makeAscending(new ArrayList<>(numbers));
    }

    private void validate(List<Integer> numbers) {
        if (!checkSize(numbers)) {
            throw new IllegalArgumentException(NUMBER_OF_LOTTO.getMessage());
        }
        if (!checkUnique(numbers)) {
            throw new IllegalArgumentException(NOT_UNIQUE.getMessage());
        }
        if (!checkRange(numbers)) {
            throw new IllegalArgumentException(RANGE_NUMBER.getMessage());
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
        return numbers.size() == LOTTO_SIZE.getLimit();
    }

    private boolean checkUnique(List<Integer> numbers) {
        List<Integer> unique = numbers.stream().distinct().toList();
        return numbers.size() == unique.size();
    }

    private boolean checkRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number ->
                number >= LOTTO_NUMBER_LOWER_LIMIT.getLimit()
                        && number <= LOTTO_NUMBER_UPPER_LIMIT.getLimit());
    }
}
