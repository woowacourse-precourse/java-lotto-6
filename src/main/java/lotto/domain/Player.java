package lotto.domain;

public class Player {
    private int money;
    private int quantity;

    public Player(int money) {
        this.money = money;
        this.quantity = money / 1000;
    }
    public int getQuantity() {
        return quantity;
    }
}