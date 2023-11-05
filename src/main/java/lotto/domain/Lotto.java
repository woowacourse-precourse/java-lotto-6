package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.exception.ExceptionMessage;

public class Lotto {
    public static final int MAX_VALUE = 45;
    public static final int MIN_VALUE = 1;
    public static final int STANDARD_SIZE = 6;
    private final List<Integer> numbers; // 필드 고정, private 도 고정

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int findSameNumberCountInLotto(Lotto generatedRandomLotto) {
        return (int) numbers.stream()
                .filter(number -> generatedRandomLotto.hasSameNumber(number))
                .count();
    }

    public boolean hasSameNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        hasStandardSize(numbers);
        hasDuplicatedNumber(numbers);
        hasOutOfRangeNumber(numbers);
    }

    private void hasStandardSize(List<Integer> numbers) {
        if (numbers.size() != STANDARD_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_LOTTO_SIZE.getErrorDescription());
        }
    }

    private void hasDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getErrorDescription());
        }
    }

    private void hasOutOfRangeNumber(List<Integer> numbers) {
        if (numbers.stream()
                .filter(number -> ((number > MAX_VALUE) || (number < MIN_VALUE)))
                .findFirst()
                .isPresent()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.getErrorDescription());
        }
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }


}
