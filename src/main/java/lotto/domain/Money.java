package lotto.domain;

public class Money {
    private static final int UNIT = 1_000;
    private final int amount;

    public Money(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (isCorrectUnit(amount)) {
            throw new IllegalArgumentException("[Error] 구매 금액은 1,000단위로만 입력 가능합니다.");
        }
        if (isZero(amount)) {
            throw new IllegalArgumentException("[Error] 구매 금액은 0원 이상만 가능합니다.");
        }
    }

    private boolean isCorrectUnit(Integer amount) {
        return amount % UNIT != 0;
    }

    private boolean isZero(Integer amount) {
        return amount == 0;
    }

    public int getPurchasingQuantity() {
        return amount / UNIT;
    }
}
