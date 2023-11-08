package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final String OUT_OF_LOTTO_VALUE_RANGE = "[ERROR] 로또 입력 값은 1이상 45이하의 값만 가능합니다.";
    public static final int LOTTO_RANGE_IN_START_VALUE = 1;
    public static final int LOTTO_RANGE_IN_END_VALUE = 45;

    private final Integer LottoNumber;

    public LottoNumber(int lottoNumber) {
        validationInRange(lottoNumber);
        LottoNumber = lottoNumber;
    }

    private boolean range(Integer number) {
        return LOTTO_RANGE_IN_START_VALUE <= number && number <= LOTTO_RANGE_IN_END_VALUE;
    }

    public void validationInRange(Integer number) {
        if (!range(number)) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_VALUE_RANGE);
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
        return LottoNumber == that.LottoNumber;
    }

    @Override
    public int hashCode() {
        return LottoNumber;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.LottoNumber, other.LottoNumber);
    }
}
