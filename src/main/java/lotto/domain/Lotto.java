package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.NumberConstants;
import lotto.validation.NumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberConstants.NUMBER_COUNT.getValue()) {
            throw NumberException.INVALID_NUMBER_COUNT_EXCEPTION.getException();
        }
    }

    public boolean isAlreadyExistNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto otherLotto) {
        return (int) numbers.stream()
            .filter(otherLotto.numbers::contains)
            .count();
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void isDuplicate(List<Integer> numbers) {
        boolean result = numbers.stream()
            .anyMatch(winningNumber -> Collections.frequency(numbers, winningNumber) > 1);
        if (result) {
            throw NumberException.DUPLICATE_NUMBER_EXCEPTION.getException();
        }
    }

    @Override
    public String toString() {
        String lottoPrintFormat = numbers.stream()
            .map(Object::toString)
            .collect(Collectors.joining(", "));
        return String.format("[%s]", lottoPrintFormat);
    }
}
