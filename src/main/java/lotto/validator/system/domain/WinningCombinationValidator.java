package lotto.validator.system.domain;

import lotto.domain.BonusNumber;
import lotto.domain.WinningCombination;
import lotto.domain.WinningLottoNumbers;
import lotto.validator.system.SystemValidator;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;

import java.util.List;

public class WinningCombinationValidator extends SystemValidator {
    public static void validateWinningNumbers(List<Integer> numbers){
        if(isSizeWrong(numbers)){
            displayMessageAndThrowException(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS);
        }
        if(isOutOfRangeLottoNumbers(numbers)){
            displayMessageAndThrowException(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER);
        }
        if(isDuplicate(numbers)){
            displayMessageAndThrowException(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER);
        }
    }

    public static void validateWinningCombination(WinningLottoNumbers winningLottoNumbers, BonusNumber bonusNumber){
        if(isDuplicateBonusNumber(winningLottoNumbers,bonusNumber.getBonusNumber())){
            displayMessageAndThrowException(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER);
        }
    }

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
