package lotto.domain;

import static lotto.view.ErrorMessage.*;
import static lotto.utils.CalculationUtils.hasDuplicates;
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

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(LOTTO_COMBINATION_DO_NOT_HAVE_DUPLICATES.getErrorMessage());
        }
    }

    public boolean isNumberIn(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumber(Lotto answer) {
        int count = 0;

        for (int number : this.numbers) {
            if (answer.isNumberIn(number)) {
                count++;
            }
        }

        return count;
    }

    public String getStatus() {
        return this.numbers.toString();
    }

}
