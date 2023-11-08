package lotto.domain;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        this.amount = Integer.parseInt(amount);
    }
    public int calculateLottoPurchaseSize() {
        return amount / 1000;
    }

    public double calculateProfitRate(Long reward) {
        return (reward / (float) amount) * 100;
    }
}