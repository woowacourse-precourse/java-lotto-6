package lotto.validator;

import org.junit.jupiter.params.ParameterizedTest;

public class UserInputValidator {

    public static int validatePurchaseAmount(String purchaseAmount){
        int amount = checkIsNumericOnly(purchaseAmount);
        checkPurchaseAmount(amount);
        return amount;
    }
    private static int checkIsNumericOnly(String purchaseAmount){
        return Integer.parseInt(purchaseAmount);
    }
    private static boolean checkPurchaseAmount(int purchaseAmount){
        if(purchaseAmount <= 0 || purchaseAmount%1000 != 0) {
            return false;
        }
        return true;
    }
}
