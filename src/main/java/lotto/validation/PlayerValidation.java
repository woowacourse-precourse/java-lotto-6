package lotto.validation;

import lotto.view.ErrorView;

public class PlayerValidation {
    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorView.getInvalidAmountErrorMessage());
        }
    }
}
