package lotto.domain.money;

public final class Money {

    private static final int MIN_AMOUNT = 0;

    private int amount;

    private Money(final int amount) {
        validateMoneyAmount(amount);
        this.amount = amount;
    }

    public static Money from(final int amount) {
        return new Money(amount);
    }

    private static void validateMoneyAmount(final int amount) {
        if (amount < MIN_AMOUNT) {
            throw new InvalidMoneyAmountException();
        }
    }
}
