package lotto.validator.system.domain;

import lotto.domain.BonusNumber;
import lotto.domain.WinningCombination;
import lotto.domain.WinningLottoNumbers;
import lotto.validator.system.SystemValidator;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;

import java.util.List;

public class WinningCombinationValidator extends SystemValidator {

    public static void validateWinningCombination(WinningLottoNumbers winningLottoNumbers, BonusNumber bonusNumber){
        if(isDuplicateBonusNumber(winningLottoNumbers,bonusNumber.getBonusNumber())){
            displayMessageAndThrowException(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER);
        }
    }
    private static void displayMessageAndThrowException(WinningCombinationInputErrorMessage message){
        message.displayMessage();
        throw new IllegalArgumentException(message.getMessage());
    }
}
