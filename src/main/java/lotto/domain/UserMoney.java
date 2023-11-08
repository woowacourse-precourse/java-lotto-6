package lotto.domain;

import java.util.Objects;
import lotto.exception.ExceptionMessage;

public class UserMoney {
    private static final int UNIT_VALUE = 1000;
    private static final int NO_REMAIN = 0;
    public static final int TO_PERCENTAGE = 100;
    private final int userMoneyValue;

    public static UserMoney from(int userMoneyValue) {
        return new UserMoney(userMoneyValue);
    }

    private UserMoney(int userMoneyValue) {
        validateMoney(userMoneyValue);
        this.userMoneyValue = userMoneyValue;
    }

    public int getLottoChances() {
        return userMoneyValue / UNIT_VALUE;
    }

    public float calculateTotalReturn(int calculateReturn) {
        if (calculateReturn == NO_REMAIN) {
            return NO_REMAIN;
        }
        return (float) calculateReturn / userMoneyValue * TO_PERCENTAGE;
    }

    private void validateMoney(int userMoneyValue) {
        if (!isDividedByUnit(userMoneyValue)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_UNIT.getErrorDescription());
        }
    }

    private boolean isDividedByUnit(int userMoneyValue) {
        return (userMoneyValue % UNIT_VALUE) == NO_REMAIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserMoney userMoney = (UserMoney) o;
        return userMoneyValue == userMoney.userMoneyValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userMoneyValue);
    }
}
