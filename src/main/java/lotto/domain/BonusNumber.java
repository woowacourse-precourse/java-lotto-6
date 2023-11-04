package lotto.domain;

import lotto.exception.ErrorMessage;

import static lotto.constants.LottoNumberConstants.MAXIMUM_RANGE;
import static lotto.constants.LottoNumberConstants.MINIMUM_RANGE;

public class BonusNumber {
    private final int number;

    private BonusNumber(String input) {
        this.number = validate(input);
    }

    public static BonusNumber create(String input) {
        return new BonusNumber(input);
    }

    private int validate(String input) {
        int number = validateNumeric(input);
        validateRange(number);
        return number;
    }

    private int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_NUMERIC.getMessage());
        }
    }

    private void validateRange(int number) {
        if (number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_INVALID_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
