package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    public static final String INSUFFICIENT_AMOUNT_MESSAGE = String.format("로또 1장의 가격은 %,d원입니다.", LOTTO_PRICE);
    public static final String NOT_DIVISIBLE_MESSAGE = String.format("%,d원으로 나누어 떨어지지 않습니다.", LOTTO_PRICE);
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getLottoPrice() { return LOTTO_PRICE; }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(INSUFFICIENT_AMOUNT_MESSAGE);
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_MESSAGE);
        }
    }
}
