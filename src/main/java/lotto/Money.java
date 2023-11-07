package lotto;

public class Money {
    private final Integer money;

    public Money(int i) {
        validate(i);
        this.money = i;
    }

    private void validate(int i) {
        ValidateMoney.isOverThousand(i);
        ValidateMoney.isUnitFollowed(i);
        ValidateMoney.isMoneyInRange(i);

    }
}
