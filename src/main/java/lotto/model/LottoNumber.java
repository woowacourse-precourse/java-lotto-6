package lotto.model;

import java.util.Objects;
import lotto.exception.CanNotConvertToNumberException;
import lotto.exception.InvalidNumberException;

public class LottoNumber implements Number {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber createWith(final String number) {
        validateConvertibleToNumber(number);
        int convertedNumber = convertToNumber(number);
        validateNumberInRange(convertedNumber);
        return new LottoNumber(convertedNumber);
    }

    public static void validateConvertibleToNumber(final String money) {
        if (!isNumeric(money)) {
            throw new CanNotConvertToNumberException(money);
        }
    }

    private static boolean isNumeric(final String money) {
        return money.chars()
                .allMatch(Character::isDigit);
    }

    private static int convertToNumber(final String money) {
        return Integer.parseInt(money);
    }

    private static void validateNumberInRange(final int number) {
        if (!isValid(number)) {
            throw new InvalidNumberException(number);
        }
    }

    private static boolean isValid(final int number) {
        return START_INCLUSIVE <= number && number <= END_INCLUSIVE;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
