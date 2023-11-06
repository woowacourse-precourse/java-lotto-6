package lotto;

public class Calculator {

    public int calculatePurchaseQuantity(int purchasePrice) {
        int removeCount = 3;
        int removed = 0;
        int purchaseQuantity = purchasePrice;
        while (removed < removeCount) {
            purchaseQuantity /= 10;
            removed++;
        }

        return purchaseQuantity;
    }
}
