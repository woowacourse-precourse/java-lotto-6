package lotto.domain;

import java.util.List;

public class WinnerNumbers {

    private final static Integer MIN_NUMBER = 1;

    private final static Integer MAX_NUMBER = 45;

    private final List<Integer> numbers;

    private final Integer bonusNumber;

    public WinnerNumbers(final List<Integer> numbers, final Integer bonusNumber) {
        validate(numbers);
        validateNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        numbers.forEach(this::validateNumber);
    }

    private void validateNumber(final Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
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
