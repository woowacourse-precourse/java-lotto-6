package lotto.model;

import lotto.exception.CanNotConvertToNumberException;
import lotto.exception.InvalidNumberException;

public class BonusNumber {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    private final int number;

    private BonusNumber(final int number) {
        this.number = number;
    }

    public static BonusNumber createWith(final String number) {
        validateConvertibleToNumber(number);
        int convertedNumber = convertToNumber(number);
        validateNumberInRange(convertedNumber);
        return new BonusNumber(convertedNumber);
    }

    private static void validateConvertibleToNumber(final String number) {
        if (isNumeric(number)) {
            throw new CanNotConvertToNumberException(number);
        }
    }

    private static boolean isNumeric(final String money) {
        return money.chars()
                .allMatch(Character::isDigit);
    }

    private static int convertToNumber(final String number) {
        return Integer.parseInt(number);
    }


    private static void validateNumberInRange(final int number) {
        if (!isValid(number)) {
            throw new InvalidNumberException(number);
        }
    }

    private static boolean isValid(final int number) {
        return START_INCLUSIVE <= number && number <= END_INCLUSIVE;
    }

    public int getNumber() {
        return number;
    }
}
