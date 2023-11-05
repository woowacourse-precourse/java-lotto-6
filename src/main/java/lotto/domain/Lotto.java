package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.constants.Number;
import lotto.utils.Validator;

public class Lotto {
    private static final int LOTTO_NUMBER_START = Number.MIN_LOTTO_NUMBER.getNumber();
    private static final int LOTTO_NUMBER_END = Number.MAX_LOTTO_NUMBER.getNumber();
    private static final int LOTTO_NUMBER_COUNT = Number.COUNT_OF_LOTTO_NUMBERS.getNumber();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbersToNaturalOrder();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        Validator.validateListSize(numbers.size(), LOTTO_NUMBER_COUNT);
        Validator.validateUniqueNumbersInRange(numbers, LOTTO_NUMBER_START, LOTTO_NUMBER_END);
    }

    private void sortNumbersToNaturalOrder() {
        this.numbers.sort(Comparator.naturalOrder());
    }
}
