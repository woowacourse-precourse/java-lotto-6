package lotto.domain;

import java.util.Objects;
import lotto.exception.ExceptionMessage;

public class UserMoney {
    private static final int UNIT_VALUE = 1000;
    private static final int NO_REMAIN = 0;
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
        if (calculateReturn == 0) {
            return 0;
        }
        return (float) calculateReturn / userMoneyValue * 100;
    }

    private void validateMoney(int userMoneyValue) {
        if (!isDividedByUnit(userMoneyValue)) { // NOT_UNIT 네이밍 다시 생각하기
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
