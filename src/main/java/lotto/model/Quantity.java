package lotto.model;

public class Quantity {
    public final int quantityNum;

    public Quantity(int purchaseAmount){
        this.quantityNum = calculateQuantity(purchaseAmount);
    }
    public int calculateQuantity(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
