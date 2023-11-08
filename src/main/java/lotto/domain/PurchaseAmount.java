package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(String amount) {
//        verification(amount);
        this.amount = Integer.parseInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }
}