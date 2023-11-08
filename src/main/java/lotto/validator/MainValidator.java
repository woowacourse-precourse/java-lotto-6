package lotto.validator;

import java.util.List;

public class MainValidator {
    private final StringValidator stringValidator = new StringValidator();
    private final NumberValidator numberValidator = new NumberValidator();
    private final DuplicateValidator duplicateValidator = new DuplicateValidator();
    public void validatePurchaseAmount(String purchaseAmount) {
        stringValidator.isNotNullValidate(purchaseAmount);
        stringValidator.hasNotBlankValidate(purchaseAmount);
        numberValidator.isDigit(purchaseAmount);
        numberValidator.isNotThounsandWonUnit(purchaseAmount);
    }

    public void validateLotto(List<Integer> lotto) {
        numberValidator.hasSixNumber(lotto);
    }

    public String[] validateBuyerLotto(String buyerLotto) {
        stringValidator.isNotNullValidate(buyerLotto);
        String[] buyerLottoNumbers = stringValidator.isSeparateByComma(buyerLotto);
        stringValidator.isSixNumber(buyerLottoNumbers);
        stringValidator.isAllDigit(buyerLottoNumbers);
        duplicateValidator.isNotDuplicate(buyerLottoNumbers);

        return buyerLottoNumbers;
    }

    public void validateBuyerBonusNumber(String buyerBonusNumber, int[] buyerLottoNumbers) {
        stringValidator.isNotNullValidate(buyerBonusNumber);
        numberValidator.isDigit(buyerBonusNumber);
        duplicateValidator.isNotDuplicateWithBuyerLotto(buyerBonusNumber, buyerLottoNumbers);
    }
}
