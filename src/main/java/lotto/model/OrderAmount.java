package lotto.model;

public class OrderAmount {
    private int money;

    public OrderAmount(int order) {
        this.money = order;
    }

    public int amountOfLotto() {
        return money/1000;
    }
}
