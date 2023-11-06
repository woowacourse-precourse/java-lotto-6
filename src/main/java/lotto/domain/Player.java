package lotto.domain;

public class Player {
    private int purchaseAmount;

    public void setPurchaseAmount(String input) {
        int purchaseAmount = toInteger(input);
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % Lotto.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
