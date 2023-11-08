package lotto.domain;

import java.util.List;

public class BonusNumber {
    private static int MIN_NUMBER = 1;
    private static int MAX_NUMBER = 45;
    private final int number;

    public BonusNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public boolean matches(List<Integer> numbers) {
        validateNumbers(numbers);
        return numbers.contains(number);
    }

    private static void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

}
