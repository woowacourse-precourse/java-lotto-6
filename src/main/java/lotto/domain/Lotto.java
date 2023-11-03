package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.utils.Validator;

public class Lotto {
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbersToNaturalOrder();
    }

    public List<Integer> showNumbers() {
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
