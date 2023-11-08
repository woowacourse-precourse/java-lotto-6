package lotto.model.dto;

public class PurchaseMoney {
    private final int money;

    public PurchaseMoney(int money) {
        this.money = money;
    }

    public int getValue() {
        return money;
    }
}
