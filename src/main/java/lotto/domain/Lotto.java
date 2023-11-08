package lotto.domain;

import java.util.List;
import lotto.util.Validation;

public class Lotto {
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.validateListNumbersInRange(numbers, LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER);
        Validation.validateListSize(numbers, LOTTO_LENGTH);
        Validation.validateListDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}