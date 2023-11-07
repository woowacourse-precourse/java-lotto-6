package lotto.domain.money;

public class Money {

    private static final int MONEY_MINIMUM_VALUE = 0;

    private int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money valueOf(int value) {
        validatePositive(value);
        return new Money(value);
    }

    private static void validatePositive(int value) {
        if (value < MONEY_MINIMUM_VALUE) {
            throw new IllegalArgumentException(
                String.format("금액은 %d원보다 작을 수 없습니다.", MONEY_MINIMUM_VALUE)
            );
        }
    }

    public int getValue() {
        return value;
    }

    public void pay(Money price) {
        payValidate(price);
        this.value -= price.value;
    }

    private void payValidate(Money price) {
        if (price.value > this.value) {
            throw new IllegalArgumentException(
                String.format("잔액 %d원 으로는 %d원의 로또를 구매하실 수 없습니다."
                    ,this.value, price.value)
            );
        }
    }

    public boolean isRemain() {
        return value > 0;
    }
}
