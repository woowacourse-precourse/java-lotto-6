package lotto.domain;

import java.util.regex.Pattern;

import static lotto.constant.Config.LOTTO_NUMBER_MAX;
import static lotto.constant.Config.LOTTO_NUMBER_MIN;
import static lotto.constant.ErrorMessage.LOTTO_NOT_IN_RANGE;
import static lotto.constant.ErrorMessage.LOTTO_NOT_NUMERIC;

public record LottoNumber(int number) {
    public LottoNumber {
        validateInRange(number);
    }

    public static LottoNumber from(String number) {
        validateNumericString(number);
        return new LottoNumber(Integer.parseInt(number));
    }


    private static void validateNumericString(String price) {
        if (!Pattern.compile("-?\\d+").matcher(price).matches()) {
            throw new IllegalArgumentException(LOTTO_NOT_NUMERIC);
        }
    }


    private static void validateInRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(LOTTO_NOT_IN_RANGE);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
