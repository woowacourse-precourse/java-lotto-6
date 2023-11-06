package lotto;

public class LottoQuantity {
    private final int quantity;

    public LottoQuantity(int amount) {
        this.quantity = calculate(amount);
    }

    private int calculate(int amount) {
        return amount / 1000;
    }

    @Override
    public String toString() {
        return String.valueOf(this.quantity);
    }
}
