package lotto.view;
import static lotto.enums.ErrorMessage.*;

public class InputValidator {

    public void validateEmptyValue(String value) throws IllegalArgumentException{
        if (value.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR.getMessage());
        }
    }

    public void validateNegativeNum(int value) throws IllegalArgumentException{
        if(value < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUM_ERROR.getMessage());
        }
    }

    public void validateLessAccount(int purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount < 1000) {
            throw new IllegalArgumentException(LESS_NUM_ERROR.getMessage());
        }
    }

    public void validatePurchaseAmountUnit(int purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount%1000!=0) {
            throw new IllegalArgumentException(ACCOUNT_UNIT_ERROR.getMessage());
        }
    }
}
