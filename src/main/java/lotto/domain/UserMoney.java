package lotto.domain;

public class UserMoney {
    private final long userMoney;

    private UserMoney(final long userMoney) {
        this.userMoney = userMoney;
    }

    public static UserMoney from(final long userMoney) {
        return new UserMoney(userMoney);
    }

    public long getUserMoney() {
        return this.userMoney;
    }
}