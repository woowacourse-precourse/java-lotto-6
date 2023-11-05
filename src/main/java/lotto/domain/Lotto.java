package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.constants.Error;
import lotto.constants.Number;
import lotto.utils.Validator;

public class Lotto {
    private static final int LOTTO_NUMBER_START = Number.MIN_LOTTO_NUMBER.getNumber();
    private static final int LOTTO_NUMBER_END = Number.MAX_LOTTO_NUMBER.getNumber();
    private static final int LOTTO_NUMBER_COUNT = Number.FIXED_LOTTO_NUMBERS_COUNT.getNumber();
    private static final String NO_NUMBERS = Error.NO_NUMBERS.getMessage();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbersToNaturalOrder();
    }

    public List<Integer> getNumbers() {
        try {
            return new ArrayList<>(numbers);
        } catch (NullPointerException e) {
            System.out.println(NO_NUMBERS);
        }
        return new ArrayList<>();
    }

    private void validate(List<Integer> numbers) {
        Validator.validateListSize(numbers.size(), LOTTO_NUMBER_COUNT);
        Validator.validateUniqueNumbersInRange(numbers, LOTTO_NUMBER_START, LOTTO_NUMBER_END);
    }

    private void sortNumbersToNaturalOrder() {
        try {
            this.numbers.sort(Comparator.naturalOrder());
        } catch (NullPointerException e) {
            System.out.println(NO_NUMBERS);
        }
    }
}
