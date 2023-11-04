package lotto.domain;

import java.util.Objects;

public class UserMoney {
    private final int userMoneyValue;

    private UserMoney(int userMoneyValue) {
        this.userMoneyValue = userMoneyValue;
    }

    public static UserMoney from(int userMoneyValue) {
        return new UserMoney(userMoneyValue);
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
