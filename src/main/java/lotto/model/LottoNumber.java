package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public record LottoNumber(int number) {

    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;

    public LottoNumber {
        validate(number);
    }

    public static LottoNumber createRandomLottoNumber() {
        return new LottoNumber(
            Randoms.pickNumberInRange(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END));
    }

    private void validate(int number) {
        if (number < LOTTO_NUMBER_RANGE_START || LOTTO_NUMBER_RANGE_END < number) {
            throw new IllegalArgumentException();
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
}
