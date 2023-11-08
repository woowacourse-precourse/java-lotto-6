package lotto.model;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object lottoNumber) {
        if (this == lottoNumber) {
            return true;
        }
        if (lottoNumber == null || getClass() != lottoNumber.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) lottoNumber;
        return number == that.number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
