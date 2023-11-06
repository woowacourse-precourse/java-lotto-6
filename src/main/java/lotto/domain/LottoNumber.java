package lotto.domain;

import static lotto.configuration.IntegerConstants.MAX_NUMBER_RANGE;
import static lotto.configuration.IntegerConstants.MIN_NUMBER_RANGE;
import static lotto.messages.ErrorMessages.INVALID_LOTTO_NUMBER_RANGE_MESSAGE;

import lotto.util.ExceptionUtil;
import lotto.validation.IntegerValidator;

public class LottoNumber {
    int number;

    private LottoNumber(int number) {
        validateInRange(number);
        this.number = number;
    }

    public static LottoNumber create(int input) {
        return new LottoNumber(input);
    }

    public static LottoNumber create(String input) {
        return new LottoNumber(processStringToInt(input));
    }

    public boolean isSameAmount(int number) {
        return this.number == number;
    }

    private static int processStringToInt(String input) {
        input = input.trim();
        IntegerValidator.validateInteger(input);

        return Integer.parseInt(input);
    }

    private void validateInRange(int number) {
        if (number < MIN_NUMBER_RANGE.getValue() || number > MAX_NUMBER_RANGE.getValue()) {
            ExceptionUtil.throwInvalidValueException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
