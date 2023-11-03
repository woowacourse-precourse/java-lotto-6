package lotto.domain;

public class LottoPurchase {
    private final Integer amount;

    public LottoPurchase(int amount) {
        this.amount = amount;
    }

    public LottoPurchase(String amount) {
        this.amount = Integer.parseInt(amount);
    }
}
