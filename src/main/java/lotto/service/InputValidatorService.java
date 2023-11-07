package lotto.service;

import lotto.validator.InputBonusNumberValidator;
import lotto.validator.InputLottoPurchaseAmountValidator;
import lotto.validator.InputWinningNumbersValidator;

public class InputValidatorService {
    private final InputLottoPurchaseAmountValidator purchaseAmountValidator = new InputLottoPurchaseAmountValidator();
    private final InputWinningNumbersValidator winningNumbersValidator = new InputWinningNumbersValidator();
    private final InputBonusNumberValidator bonusNumberValidator = new InputBonusNumberValidator();

    public void validateInputPurchaseAmount(String purchaseAmount) {
        purchaseAmountValidator.validateNonInputPurchaseAmount(purchaseAmount);
        purchaseAmountValidator.validateNonIntegerPurchaseAmount(purchaseAmount);
        purchaseAmountValidator.validateNonDivide1000PurchaseAmount(purchaseAmount);
    }

    public void validateInputWinningNumbers(String winningNumbers) {
        winningNumbersValidator.validateNonInputWinningNumbers(winningNumbers);
        winningNumbersValidator.validateNonNumberSizeSix(winningNumbers);
        winningNumbersValidator.validateWrongRangeWinningNumbers(winningNumbers);
        winningNumbersValidator.validateDuplicateWinningNumbers(winningNumbers);
        winningNumbersValidator.validateNonCommaWinningNumbers(winningNumbers);
    }

    public void validateInputBonusNumber(String bonusNumber) {
        bonusNumberValidator.validateNonInputBonusNumber(bonusNumber);
        bonusNumberValidator.validateNonIntegerBonusNumber(bonusNumber);
        bonusNumberValidator.validateWrongRangeBonusNumber(bonusNumber);
    }
}
