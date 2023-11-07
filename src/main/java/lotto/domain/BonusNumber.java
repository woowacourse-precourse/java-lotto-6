package lotto.domain;

import java.util.Objects;
import lotto.exception.InvalidNumberScopeException;

public class BonusNumber {
    private static final Integer MINIMUM_LOTTO_NUMBER = 1;
    private static final Integer MAXIMUM_LOTTO_NUMBER = 45;
    private Integer number;

    public BonusNumber(Integer number) {
        validateScope(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private void validateScope(Integer number) {
        if (number < MINIMUM_LOTTO_NUMBER) {
            throw new InvalidNumberScopeException();
        }
        if (number > MAXIMUM_LOTTO_NUMBER) {
            throw new InvalidNumberScopeException();
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
        BonusNumber lottoNumber = (BonusNumber) o;
        return Objects.equals(number, lottoNumber.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
