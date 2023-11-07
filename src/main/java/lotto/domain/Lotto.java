package lotto.domain;

import lotto.utils.Utils;
import lotto.validate.Validation;

import java.util.List;

public class Lotto {
    private static final int VALID_LOTTO_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Utils.sortListNaturalOrder(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLengthOfList(numbers, VALID_LOTTO_SIZE);
        Validation.validateDuplicationList(numbers);
        Validation.validateListNumberInRange(numbers, MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER);
    }

}
