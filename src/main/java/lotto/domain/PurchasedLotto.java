package lotto.domain;

public class PurchasedLotto {
    private static final int LOTTO_PRICE = 1000;
    private final Money money;

    public PurchasedLotto(final Money money) {
        this.money = money;
    }

    public int getBuyQuantity() {
        return money.getAmount() / LOTTO_PRICE;
    }
}