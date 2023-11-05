package lotto;

public class Calculator {

    public int calculatePurchaseQuantity(int purchasePrice) {
        int removeCount = 3;
        int removed = 0;
        while (removed < removeCount) {
            purchasePrice /= 10;
            removed++;
        }

        int purchaseQuantity = purchasePrice;

        return purchaseQuantity;
    }
}
