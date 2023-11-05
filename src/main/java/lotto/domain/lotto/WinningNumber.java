package lotto.domain.lotto;

import static lotto.global.constant.NumberDefinition.END_INCLUSIVE;
import static lotto.global.constant.NumberDefinition.START_INCLUSIVE;

public class WinningNumber {

    private final Integer number;

    public WinningNumber(Integer number) {
        this.number = number;
        validateNumberIsInRange(number);
    }

    public void validateNumberIsInRange(Integer number) {
        if (number < START_INCLUSIVE.getNumber() || number > END_INCLUSIVE.getNumber()) {
            throw new IllegalArgumentException("숫자가 범위 밖임");
        }
    }

    public boolean isEqualsToLottoNumber(Integer lottoNumber) {
        if(this.number.equals(lottoNumber)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinningNumber that = (WinningNumber) o;

        return number != null ? number.equals(that.number) : that.number == null;
    }

    public Integer getNumber() {
        return number;
    }
}
