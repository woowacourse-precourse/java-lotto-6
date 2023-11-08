package lotto.controller.validator;

import lotto.domain.DomainConstants;

public class BonusNumberValidator {

    public void validateBonusNumber(String userInput) {
        validateOnlyOneNumber(userInput);
        validateBonusNumberRange(userInput);
    }

    private void validateOnlyOneNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if(!Character.isDigit(userInput.charAt(i))){
                throw new IllegalArgumentException(DomainConstants.ONLY_ONE_NUMBER_MESSAGE);
            }
        }
    }

    private void validateBonusNumberRange(String userInput) {
        int bonusNumber = Integer.parseInt(userInput);
        if (!(bonusNumber >= DomainConstants.LOTTO_MIN_NUM && bonusNumber <= DomainConstants.LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(DomainConstants.BONUS_NUM_RANGE_MESSAGE);
        }
    }
}