package lotto.domain.lotto;

import static lotto.domain.lotto.LottoRule.*;

import java.util.Objects;
import lotto.domain.message.ErrorMessage;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_MIN_NUMBER_INCLUSION.getValue()
                || number > LOTTO_MAX_NUMBER_INCLUSION.getValue()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NUMBER_RANGE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
