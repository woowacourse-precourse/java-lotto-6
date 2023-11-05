package lotto.dto;

public class LottoPurchase {
    private final int money;

    private LottoPurchase() {
        this.money = 0;
    }

    private LottoPurchase(int money) {
        this.money = money;
    }

    public static LottoPurchase from(int purchaseMoney) {
        return new LottoPurchase(purchaseMoney);
    }

    public int getMoney() {
        return money;
    }
}
