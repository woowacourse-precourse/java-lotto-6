package lotto.domain;

import java.util.Objects;
import lotto.util.ValidationUtils;

public class BonusNumber {

    private final int MIN_NUMBER_RANGE = 1;
    private final int MAX_NUMBER_RANGE = 45;

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        ValidationUtils.validateNotNull(number);
        validateNumberInRange(number);
    }

    private void validateNumberInRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
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
        BonusNumber bonusNumber1 = (BonusNumber) o;
        return number == bonusNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
