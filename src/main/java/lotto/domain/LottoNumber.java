package lotto.domain;

import static lotto.constants.ErrorCode.INVALID_LOTTO_RANGE;
import static lotto.constants.LottoRule.MAX_LOTTO_NUM;
import static lotto.constants.LottoRule.MIN_LOTTO_NUM;

import java.util.Objects;
import lotto.validator.Validator;

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
        Validator.validateIsInteger(input);
        validateNumberRange(input);
    }

    private void validateNumberRange(String input) {
        int converted = Integer.parseInt(input);
        if (converted < MIN_LOTTO_NUM.getValue() || converted > MAX_LOTTO_NUM.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottoNumber that)) {
            return false;
        }
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
