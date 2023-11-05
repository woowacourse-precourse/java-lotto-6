package lotto.domain;

public class Quantity {
    private final int quantity;

    private Quantity(final int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("[ERROR] QUANTITY SHOULD BE MORE THAN 1");
        }
        this.quantity = quantity;
    }

    public static Quantity of(final Money budget, final int price) {
        return new Quantity((int) budget.getValue() / price);
    }

    public int getQuantity() {
        return quantity;
    }
}
