package lotto.domain;

public class Purchase {
    private final int money;

    public Purchase(int money) {
        this.money = money;
    }

    public int getAvailableCount() {
        return money / 1000;
    }
}
