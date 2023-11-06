package lotto.model;

public class Quantity {
    private final int quantity;

    public Quantity(int purchaseAmount){
        this.quantity = calculateQuantity(purchaseAmount);
    }
    public int calculateQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
