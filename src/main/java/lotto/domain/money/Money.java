package lotto.domain.money;

public class Money {

    private int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money valueOf(int value) {
        return new Money(value);
    }

    public int getValue() {
        return value;
    }

    public void pay(Money price) {
        payValidate(price);
        this.value -= price.value;
    }

    private void payValidate(Money price) {
        if (!canPay(price)) {
            throw new IllegalArgumentException(
                String.format("잔액 %d원 으로는 %d원의 물건을 구매하실 수 없습니다."
                    , this.value, price.value)
            );
        }
    }

    public boolean canPay(Money price) {
        return this.value - price.value >= 0;
    }
}
