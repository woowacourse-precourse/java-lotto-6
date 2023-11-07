package lotto.domain;

import static lotto.global.constant.LottoNumberType.LENGTH_OF_LOTTO;
import static lotto.global.constant.LottoNumberType.MAX_RANGE_OF_LOTTO;
import static lotto.global.constant.LottoNumberType.MIN_RANGE_OF_LOTTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.constant.ConsoleType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        this.numbers = Collections.unmodifiableList(sortedNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LENGTH_OF_LOTTO.getValue()) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION.getComment());
        }
        numbers.forEach(this::validateNumberRange);
        validateNumberUnique(numbers);
    }

    private void validateNumberUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ConsoleType.EMPTY.getComment());
        }
    }

    private void validateNumberRange(Integer number) {
        if (!(number >= MIN_RANGE_OF_LOTTO.getValue() && number <= MAX_RANGE_OF_LOTTO.getValue())) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION.getComment());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
