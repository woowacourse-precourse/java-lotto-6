package lotto;

public class Money {

    private final Integer money;
    private final static Integer MIN_UNIT_MONEY = 1000;
    private final static Integer ZERO = 0;

    private Money(Integer money) {
        validateRemainMoney(money);
        validateZeroMoney(money);
        this.money = money;
    }

    public static Money of(Integer money) {
        return new Money(money);
    }

    private void validateZeroMoney(Integer money) {
        if (isZero(money)) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private boolean isZero(Integer money) {
        return money.equals(ZERO);
    }

    private void validateRemainMoney(Integer money) {
        if (hasRemain(money)) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private boolean hasRemain(Integer money) {
        return money % MIN_UNIT_MONEY != 0;
    }
}
