package lotto.domain;

public class Quantity {
    private final int quantity;

    public Quantity(final Price price) {
        this.quantity = price.toInt();
    }

    public int getQuantity() {
        return quantity / Price.STANDARD_UNIT;
    }
}
