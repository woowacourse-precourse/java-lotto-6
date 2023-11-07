package lotto.domain;

import static lotto.configuration.IntegerConstants.MAX_NUMBER_RANGE;
import static lotto.configuration.IntegerConstants.MIN_NUMBER_RANGE;
import static lotto.messages.ErrorMessages.INVALID_LOTTO_NUMBER_RANGE_MESSAGE;

import lotto.util.ExceptionUtil;
import lotto.util.IntegerUtil;
import lotto.validation.IntegerValidator;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        IntegerValidator.validateInRange(number, MIN_NUMBER_RANGE.getValue(), MAX_NUMBER_RANGE.getValue());
        this.number = number;
    }

    public static LottoNumber create(int input) {
        return new LottoNumber(input);
    }

    public static LottoNumber create(String input) {
        return new LottoNumber(IntegerUtil.trimAndParseInt(input));
    }

    public boolean isSameAmount(int number) {
        return this.number == number;
    }
}
