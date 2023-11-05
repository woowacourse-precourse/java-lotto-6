package lotto.model;

import java.util.Objects;
import lotto.validator.BonusNumberValidator;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        BonusNumberValidator.validate(number);
        this.number = number;
    }


    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BonusNumber that = (BonusNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
