package lotto.model;

import java.util.List;

public class BonusNumber {

    private final int number;

    private BonusNumber(final int number) {
        this.number = number;
    }

    public static BonusNumber from(final String numberInput) {
        int number = convertToNumber(numberInput);
        return new BonusNumber(number);
    }

    private static int convertToNumber(final String numberInput) {
        try {
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNumbersContainBonus(final List<Integer> numbers) {
        return numbers.contains(number);
    }

    public int getNumber() {
        return number;
    }
}
