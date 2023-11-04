package lotto.model;

import static lotto.view.exception.InputException.NUMBER_FORMAT_EXCEPTION;

import lotto.model.constants.LottoRule;

public class BonusNumber {

    private final int number;

    private BonusNumber(final int number) {
        this.number = number;
    }

    public static BonusNumber from(final String numberInput) {
        int number = convertToNumber(numberInput);
        LottoRule.validateNumberValue(number);

        return new BonusNumber(number);
    }

    private static int convertToNumber(final String numberInput) {
        try {
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
