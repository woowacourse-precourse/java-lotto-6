package lotto.validates;

import lotto.constants.PurchaseUnit;
import lotto.errors.PurchaseError;

public class PurchaseValidate {

    public static void validate(int purchaseAmount) {
        negativeAmountValidate(purchaseAmount);
        notMultipleOfUnitValidate(purchaseAmount);
    }

    private static void negativeAmountValidate(int purchaseAmount) {
        if (purchaseAmount < 0) {
            PurchaseError errorMessage = PurchaseError.NEGATIVE_AMOUNT;
            throw new IllegalArgumentException(errorMessage.getErrorMessage());
        }
    }

    private static void notMultipleOfUnitValidate(int purchaseAmount) {
        int purchaseUnit = PurchaseUnit.THOUSAND.getValue();

        if (purchaseAmount % purchaseUnit != 0) {
            PurchaseError errorMessage = PurchaseError.NOT_MULTIPLE_OF_UNIT;
            throw new IllegalArgumentException(String.format(errorMessage.getErrorMessage(), purchaseUnit));
        }
    }

}
