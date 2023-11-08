package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        LottoValidator.validateNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
