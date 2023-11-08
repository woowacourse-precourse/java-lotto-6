package lotto.validator;

import java.util.List;

public class MainValidator {
    private final StringValidator stringValidator = new StringValidator();
    private final NumberValidator numberValidator = new NumberValidator();
    public void validatePurchaseAmount(String purchaseAmount) {
        stringValidator.isNotNullValidate(purchaseAmount);
        stringValidator.hasNotBlankValidate(purchaseAmount);
        numberValidator.isDigit(purchaseAmount);
        numberValidator.isNotThounsandWonUnit(purchaseAmount);
    }

    public void validateLotto(List<Integer> lotto) {
        numberValidator.hasSixNumber(lotto);
    }
}
