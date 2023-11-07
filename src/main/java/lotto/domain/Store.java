package lotto.domain;

public class Store {

    private static final int MAX_INPUT= 2_100_000_000;
    private static final int LOTTO_PRICE = 1_000;

    private final int price;

    public Store(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (isLowerThanMinimumPrice(price)) {
            throw new IllegalArgumentException();
        }
        if (isDivisibleByMinimumPrice(price)) {
            throw new IllegalArgumentException();
        }
        if (isHigherThanMaxInput(price)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isLowerThanMinimumPrice(int price) {
        return price < LOTTO_PRICE;
    }

    private boolean isDivisibleByMinimumPrice(int price) {
        return price % LOTTO_PRICE != 0;
    }

    private boolean isHigherThanMaxInput(int price) {
        return price > MAX_INPUT;
    }

    public int getLottoCount() {
        return this.price / LOTTO_PRICE;
    }

    public int getMoney() {
        return this.price;
    }

}
