package model;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        return new LottoNumber(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object value) {
        if (value == this) {
            return true;
        }

        if (!(value instanceof LottoNumber lottoNumber)) {
            return false;
        }

        return lottoNumber.number == number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
