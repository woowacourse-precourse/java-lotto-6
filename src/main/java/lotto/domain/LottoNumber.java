package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final Integer MAX_LOTTO_NUMBER = 45;
    public static final Integer MIN_LOTTO_NUMBER = 1;


    private Integer lottoNumber;


    public LottoNumber(Integer lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(String winningNumber) {
        this.lottoNumber = Integer.valueOf(winningNumber);
    }

    private void validateRange(Integer intNumber) {
        if (intNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 수로 구성되어야합니다");
        }

        if (intNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 수로 구성되어야합니다");
        }
    }

    public Integer getLottoNumber() {
        return lottoNumber;
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
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
