package lotto.model;

import lotto.constants.ExceptionMessages;
import lotto.constants.LottoConstants;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isNotSixNumbers(numbers)) {
            ExceptionMessages.WRONG_AMOUNT_LOTTO_NUMBERS.throwException();
        }
        if (isWrongRangeNumbers(numbers)) {
            ExceptionMessages.WRONG_RANGE_LOTTO_NUMBERS.throwException();
        }
    }

    private boolean isNotSixNumbers(List<Integer> numbers) {
        return numbers.size() != LottoConstants.NUMBER_OF_LOTTO_NUMBERS;
    }

    private boolean isWrongRangeNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoConstants.MINIMUM_LOTTO_NUMBER || number > LottoConstants.MAXIMUM_LOTTO_NUMBER) {
               return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int calculateSameNumbers(Lotto lotto) {
        long sameNumberCount = numbers.stream()
                .filter(number -> lotto.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
        return (int) sameNumberCount;
    }

    public boolean hasNumber(int number) {
        return getNumbers().contains(number);
    }
}
