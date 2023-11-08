package lotto.domain.model;

import static lotto.domain.model.LottoErrorMessages.*;

import java.util.Objects;
import lotto.domain.LottoConfig;


public class LottoNumber {

    private final int number;

    public LottoNumber(final int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(
                    INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int number) {
        return number < LottoConfig.MIN_NUMBER.getValue()
                || number > LottoConfig.MAX_NUMBER.getValue();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) obj;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
