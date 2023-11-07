package lotto;

import domain.PurchaseInput;

public class Application {
    public static void main(String[] args) {
        PurchaseInput purchaseInput = new PurchaseInput();
        int purchaseAmount = purchaseInput.getPurchaseAmount();
    }
}
