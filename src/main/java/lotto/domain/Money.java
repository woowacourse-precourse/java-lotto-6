package lotto.domain;

public class Money {
    public static final String INSUFFICIENT_AMOUNT_MESSAGE = "로또 1장의 가격은 1,000원입니다.";
    public static final String NOT_DIVISIBLE_MESSAGE = "1,000원으로 나누어 떨어지지 않습니다.";
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(INSUFFICIENT_AMOUNT_MESSAGE);
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_MESSAGE);
        }
    }

    public int getLottoPrice() { return LOTTO_PRICE; }

    public int getAmount() {
        return amount;
    }
}
