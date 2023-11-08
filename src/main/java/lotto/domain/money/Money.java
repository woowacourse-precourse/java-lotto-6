package lotto.domain.money;

import java.util.Objects;

public class Money {

    public static final Money ZERO = new Money(0);

    private static final Integer MINIMUM_AMOUNT = 1000;
    private final Integer money;
    private Money(Integer money) {
        this.money = money;
    }

    public Integer calcBillCount() {
        return money / MINIMUM_AMOUNT;
    }

    public Double calcProfitRate(Money money) {
        return (this.money / (double) money.money) * 100;
    }

    public Money sum(Money operand) {
        return new Money(money + operand.money);
    }

    public Integer toInt() {
        return money;
    }

    public static Money from(Integer money) {
        validateRemainMoney(money);
        validateMinimumAmount(money);
        return new Money(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    private static void validateMinimumAmount(Integer money) {
        if (isMin(money)) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private static boolean isMin(Integer money) {
        return money < MINIMUM_AMOUNT;
    }

    private static void validateRemainMoney(Integer money) {
        if (hasRemain(money)) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private static boolean hasRemain(Integer money) {
        return money % MINIMUM_AMOUNT != 0;
    }
}
