package lotto.input;

public class InputValidator {
    public void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
