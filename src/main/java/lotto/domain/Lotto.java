package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.constants.NumberRule;
import lotto.utils.Validator;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = NumberRule.MIN_LOTTO_NUMBER.getNumber();
    private static final int MAX_LOTTO_NUMBER = NumberRule.MAX_LOTTO_NUMBER.getNumber();
    private static final int COUNT_OF_LOTTO_NUMBERS = NumberRule.COUNT_OF_LOTTO_NUMBERS.getNumber();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbersByNaturalOrder();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        Validator.validateSize(numbers.size(), COUNT_OF_LOTTO_NUMBERS);
        Validator.validateUniqueNumbersInRange(numbers, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }

    private void sortNumbersByNaturalOrder() {
        numbers.sort(Comparator.naturalOrder());
    }
}
