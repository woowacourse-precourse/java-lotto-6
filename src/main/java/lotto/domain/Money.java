package lotto.domain;

public class Money {

    private final Integer money;
    private final static Integer MINIMUM_AMOUNT = 1000;

    private Money(Integer money) {
        validateRemainMoney(money);
        validateMinimumAmount(money);
        this.money = money;
    }

    public Integer calcBillCount() {
        return money / MINIMUM_AMOUNT;
    }

    public static Money of(Integer money) {
        return new Money(money);
    }

    private void validateMinimumAmount(Integer money) {
        if (isMin(money)) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private boolean isMin(Integer money) {
        return money < MINIMUM_AMOUNT;
    }

    private void validateRemainMoney(Integer money) {
        if (hasRemain(money)) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private boolean hasRemain(Integer money) {
        return money % MINIMUM_AMOUNT != 0;
    }

}
