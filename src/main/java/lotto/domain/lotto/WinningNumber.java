package lotto.domain.lotto;

import java.util.Objects;

import static lotto.global.constant.NumberDefinition.END_INCLUSIVE;
import static lotto.global.constant.NumberDefinition.START_INCLUSIVE;
import static lotto.global.constant.exception.ExceptionMessage.NUMBERS_OUT_OF_RANGE;

public class WinningNumber {

    private final Integer number;

    public WinningNumber(Integer number) {
        this.number = number;
        validateNumberIsInRange(number);
    }

    public void validateNumberIsInRange(Integer number) {
        if (number < START_INCLUSIVE.getNumber() || number > END_INCLUSIVE.getNumber()) {
            throw new IllegalArgumentException(NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    public boolean isEqualsToLottoNumber(Integer lottoNumber) {
        return this.number.equals(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinningNumber that = (WinningNumber) o;

        return Objects.equals(number, that.number);
    }

    public Integer getNumber() {
        return number;
    }
}
