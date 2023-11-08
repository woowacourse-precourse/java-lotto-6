package lotto.validator.system.domain;

import lotto.validator.system.SystemValidator;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;

public class BonusNumberValidator extends SystemValidator {
    public static void validateBonusNumber(int bonusNumber){
        if(isOutOfRangeBonusNumber(bonusNumber)){
            displayMessageAndThrowException(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER);
        }
    }

    private static void displayMessageAndThrowException(WinningCombinationInputErrorMessage message){
        message.displayMessage();
        throw new IllegalArgumentException(message.getMessage());
    }
}
