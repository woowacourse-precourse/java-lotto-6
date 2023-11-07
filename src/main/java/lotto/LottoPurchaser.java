package lotto;

public class LottoPurchaser {
    private final Money money;

    public LottoPurchaser(final Money money) {
        this.money = money;
    }

    public int purchase() {
        return money.purchase();
    }

    public int purchaseMoney() {
        return money.purchaseMoney();
    }
}
