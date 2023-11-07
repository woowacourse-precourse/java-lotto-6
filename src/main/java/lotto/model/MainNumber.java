package lotto.model;

import static lotto.common.Constant.MAX_RANGE;
import static lotto.common.Constant.MIN_RANGE;

import java.util.Objects;
import lotto.util.validator.BlankValidator;
import lotto.util.validator.IntegerValidator;

public class MainNumber {
    private final int mainNumber;

    private MainNumber(String mainNumber) {
        validate(mainNumber);
        this.mainNumber = Integer.parseInt(mainNumber);
    }

    public static MainNumber from(String mainNumber) {
        return new MainNumber(mainNumber);
    }

    private void validate(String mainNumber) {
        BlankValidator.validate(mainNumber);
        IntegerValidator.validateInteger(mainNumber);
        IntegerValidator.validateRange(mainNumber, MIN_RANGE, MAX_RANGE);
    }

    public boolean isNumberEqual(int number) {
        return mainNumber == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MainNumber that = (MainNumber) o;
        return mainNumber == that.mainNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainNumber);
    }
}
