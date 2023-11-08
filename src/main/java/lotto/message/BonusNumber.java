package lotto.message;

import static lotto.Lotto.LOTTO_END_NUMBER;
import static lotto.Lotto.LOTTO_START_NUMBER;
import static lotto.message.LottoGameErrorMessage.NOT_ABLE_TO_PARSE_INT_MESSAGE;
import static lotto.message.LottoGameErrorMessage.NUMBERS_NOT_IN_RANGE;

import org.assertj.core.util.VisibleForTesting;

public class BonusNumber {
    private final int number;

    public BonusNumber(String input) {
        validate(input);
        this.number = Integer.parseInt(input);
    }

    private static void validate(String input) {
        if (!isAbleToParseInteger(input)) {
            throw new IllegalArgumentException(NOT_ABLE_TO_PARSE_INT_MESSAGE.getMessage());
        }
        if (!isNumberInRange(Integer.parseInt(input))) {
            throw new IllegalArgumentException(NUMBERS_NOT_IN_RANGE.getMessage());
        }
    }

    @VisibleForTesting
    protected static boolean isAbleToParseInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @VisibleForTesting
    protected static boolean isNumberInRange(int number) {
        return LOTTO_START_NUMBER <= number && number <= LOTTO_END_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
