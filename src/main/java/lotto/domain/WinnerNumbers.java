package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerNumbers {

    private final static Integer MIN_NUMBER = 1;

    private final static Integer MAX_NUMBER = 45;

    private final List<Integer> numbers;

    private final Integer bonusNumber;

    public WinnerNumbers(final List<Integer> numbers, final Integer bonusNumber) {
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.numbers = numbers;

    }

    private void validate(final List<Integer> numbers, final Integer bonusNumber) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        numbers.forEach(this::validateNumber);
        validateNumber(bonusNumber);
        validateNoDuplicatedNumbers(numbers, bonusNumber);
    }

    private void validateNumber(final Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicatedNumbers(final List<Integer> numbers, final Integer bonusNumber) {
        final List<Integer> numbersWithBonusNumber = new ArrayList<>(numbers);
        numbersWithBonusNumber.add(bonusNumber);
        if (numbersWithBonusNumber.stream().distinct().count() != numbersWithBonusNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean containNumber(final Integer number) {
        return numbers.contains(number);
    }

    public boolean containBonusNumber(final Integer number) {
        return bonusNumber.equals(number);
    }
}
