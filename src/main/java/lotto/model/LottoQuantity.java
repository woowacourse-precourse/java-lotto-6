package lotto.model;

public class LottoQuantity {
    private final int quantity;

    public LottoQuantity(int amount) {
        this.quantity = calculate(amount);
    }

    public int getQuantity() {
        return quantity;
    }

    private int calculate(int amount) {
        return amount / 1000;
    }
}
