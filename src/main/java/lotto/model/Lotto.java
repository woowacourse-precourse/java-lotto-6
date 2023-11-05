package lotto.model;

import static lotto.model.constans.LottoConstants.*;
import static lotto.validator.constants.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validator.constants.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers) || isInvalidRange(numbers) || hasDuplicates(numbers)) {
            throw new IllegalArgumentException(LOTTO_ERROR.message());
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE.value();
    }

    private boolean isInvalidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER.value() || MAX_LOTTO_NUMBER.value() < number) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() < numbers.size();
    }

    @Override
    public String toString() {
        List<Integer> clonedNumbers = new ArrayList<>(numbers);
        sortNumbers(clonedNumbers);
        return clonedNumbers.toString();
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public boolean contains(int targetNumber) {
        return numbers.contains(targetNumber);
    }
}
