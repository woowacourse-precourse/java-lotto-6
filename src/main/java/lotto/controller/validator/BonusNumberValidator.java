package lotto.controller.validator;

import lotto.constant.LottoConstants;

public class BonusNumberValidator implements InputValidator {
    private static BonusNumberValidator bonusNumberValidator;

    private BonusNumberValidator() {
    }

    public static BonusNumberValidator getInstance() {
        if (bonusNumberValidator == null) {
            bonusNumberValidator = new BonusNumberValidator();
            return bonusNumberValidator;
        }
        return bonusNumberValidator;
    }

    @Override
    public void validate(String userInput) {
        validateInteger(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        validateNumberInRange(bonusNumber);
    }

    public void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
    }

    public void validateNumberInRange(int number) {
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE.getMessage());
        }
    }
}
