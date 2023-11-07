package lotto.model;

import static lotto.common.Constant.MAX_RANGE;
import static lotto.common.Constant.MIN_RANGE;
import static lotto.common.ExceptionMessage.NUMBER_NOT_IN_RANGE_ERROR;

import java.util.Objects;
import lotto.util.validator.BlankValidator;
import lotto.util.validator.NumericValidator;

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
        NumericValidator.validateInteger(mainNumber);
        validateRange(mainNumber);
    }

    private void validateRange(String mainNumber) {
        if (!isBetweenRange(Integer.parseInt(mainNumber))) {
            throw new IllegalArgumentException(NUMBER_NOT_IN_RANGE_ERROR);
        }
    }

    private boolean isBetweenRange(int mainNumber) {
        return (MIN_RANGE <= mainNumber) && (mainNumber <= MAX_RANGE);
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
