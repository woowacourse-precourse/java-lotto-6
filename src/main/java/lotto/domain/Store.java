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
            throw new IllegalArgumentException("[ERROR] 최소 금액보다는 작은값을 입력하셨습니다.");
        }
        if (isNotDivisibleByMinimumPrice(price)) {
            throw new IllegalArgumentException("[ERROR] 최소 금액으로 나누어 떨어지는 값을 입력해주세요.");
        }
        if (isHigherThanMaxInput(price)) {
            throw new IllegalArgumentException("[ERROR] 최대 금액보다 큰 값을 입력하셨습니다.");
        }
    }

    private boolean isLowerThanMinimumPrice(int price) {
        return price < LOTTO_PRICE;
    }

    private boolean isNotDivisibleByMinimumPrice(int price) {
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
