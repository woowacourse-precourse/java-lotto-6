package lotto.domain;

import static lotto.constants.ErrorCode.INVALID_LOTTO_NUMBER;
import static lotto.constants.ErrorCode.NOT_INTEGER;
import static lotto.constants.LottoRule.MAX_LOTTO_NUM;
import static lotto.constants.LottoRule.MIN_LOTTO_NUM;

public class LottoNumber {
    private int number;

    private LottoNumber(String input) {
        validateLottoNumber(input);
        this.number = Integer.parseInt(input);
    }

    public static LottoNumber from(String input) {
        return new LottoNumber(input);
    }

    private void validateLottoNumber(String input) {
        isInteger(input);
        validateNumberRange(input);
    }

    private void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }

    private void validateNumberRange(String input) {
        int converted = Integer.parseInt(input);
        if (converted < MIN_LOTTO_NUM.getValue() || converted > MAX_LOTTO_NUM.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }


}
