package lotto.model;

public class Money {
    private static final int ZERO = 0;
    private static final String INPUT_MONEY_MORE_THAN_ZERO = "[ERROR] 로또 구입 금액은 0원보다 많아야 합니다.";
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    private void validateMoreThanZero(int inputBuyAccount) {
        if (inputBuyAccount <= ZERO) {
            throw new IllegalArgumentException(INPUT_MONEY_MORE_THAN_ZERO);
        }
    }
}
