package lotto.Model;

import lotto.View.ExceptionMessages;

public class
BonusNumber {
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        int bonusNumberInt = validateIsNumeric(bonusNumber);
        validateIsNumberInRange(bonusNumberInt);
        this.bonusNumber = bonusNumberInt;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static int validateIsNumeric(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ExceptionMessages.bonusNumberTypeError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNumberInRange(int number) {
        if (number < MIN_BONUS_NUMBER || number > MAX_BONUS_NUMBER) {
            ExceptionMessages.bonusNumberRangeError();
            throw new IllegalArgumentException();
        }
    }
}
