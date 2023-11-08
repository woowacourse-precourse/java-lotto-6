package lotto.service;

import lotto.validator.InputValidator;

public class ValidateService {

    private final InputValidator inputValidator = new InputValidator();

    public void validateInputPurchaseMoney(String inputPurchaseMoney) {
        inputValidator.validatePurchaseMoney(inputPurchaseMoney);
    }

    public void validateInputWinnerNumber(String inputWinningNumber) {
        inputValidator.validateWinnerNumber(inputWinningNumber);
    }

    public void validateInputBonusNumber(String inputBonusNumber) {
        inputValidator.validateBonusNumber(inputBonusNumber);
    }
}
