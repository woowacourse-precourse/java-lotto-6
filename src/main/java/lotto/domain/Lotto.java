package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lotto.converter.SortNumbersConverter;
import lotto.validator.LottoNumbersValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(createSortedNumbers(numbers));
    }

    private void validate(List<Integer> numbers) {
        LottoNumbersValidator.validate(numbers);
    }

    private List<Integer> createSortedNumbers(final List<Integer> numbers) {
        SortNumbersConverter converter = new SortNumbersConverter();
        return converter.convert(numbers);
    }

    public int compare(final Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(this::hasNumber)
                .count();
    }

    public boolean hasNumber(final int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(final Object o) {
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

    @Override
    public String toString() {
        return numbers.toString();
    }

}
