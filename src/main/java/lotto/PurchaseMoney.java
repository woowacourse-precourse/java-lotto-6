package lotto;

public class PurchaseMoney {
    private static int LOTTO_PRICE = 1000;

    private final int amount;

    public PurchaseMoney(int amount) {
        this.amount = amount;
    }

    public int getLottoQuantity() {
        return amount / LOTTO_PRICE;
    }
}