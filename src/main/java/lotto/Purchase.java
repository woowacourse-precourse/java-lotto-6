package lotto;

import java.util.List;

public class Purchase {
    private final int purchaseAmount;

    public Purchase(String purchaseInput) {
        this.purchaseAmount = validate(purchaseInput);
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    private int validate(String purchaseInput) {

        int purchaseAmount;

        try {
            purchaseAmount = Integer.parseInt(purchaseInput);

            if (purchaseAmount % 1000 == 0) {
                return purchaseAmount;
            }

            throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
