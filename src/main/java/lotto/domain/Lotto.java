package lotto.domain;

import static lotto.domain.ErrorMessage.*;
import static lotto.utils.CalculationUtils.isNumberInRange;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_COMBINATION_HAVE_SIX_NUMBER.getErrorMessage());
        }

        for (Integer number : numbers) {
            if (!isNumberInRange(number, 1, 45)) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_IS_BETWEEN_ONE_AND_FORTYFIVE.getErrorMessage());
            }
        }
    }
}
