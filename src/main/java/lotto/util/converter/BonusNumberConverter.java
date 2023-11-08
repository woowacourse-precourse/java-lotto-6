package lotto.util.converter;

import lotto.util.Constants;
import lotto.util.exception.InvalidLottoNumberRangeException;

public class BonusNumberConverter {
    private BonusNumberConverter() {
    }

    public static int convertAndValidate(String input) {
        int number = convertToInteger(input);
        validateNumberRange(number);
        return number;
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidLottoNumberRangeException();
        }
    }

    private static void validateNumberRange(int value) {
        if (value < Constants.LOTTO_MIN_NUMBER || value > Constants.LOTTO_MAX_NUMBER) {
            throw new InvalidLottoNumberRangeException();
        }
    }
}
