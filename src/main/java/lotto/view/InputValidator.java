package lotto.view;

import static lotto.enums.ErrorMessage.*;

public class InputValidator {
    public void validateNegativeNum(int value) throws IllegalArgumentException{
        if(value < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUM_ERROR.getMessage());
        }
    }

    public void validateLessAccount(int purchaseAccount) throws IllegalArgumentException{
        if(purchaseAccount < 1000) {
            throw new IllegalArgumentException(LESS_NUM_ERROR.getMessage());
        }
    }

    public void validatePurchaseAccountUnit(int purchaseAccount) throws IllegalArgumentException{
        if(purchaseAccount%1000!=0) {
            throw new IllegalArgumentException(ACCOUNT_UNIT_ERROR.getMessage());
        }
    }
}
