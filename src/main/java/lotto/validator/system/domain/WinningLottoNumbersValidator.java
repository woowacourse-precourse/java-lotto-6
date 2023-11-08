package lotto.validator.system.domain;

import lotto.validator.system.SystemValidator;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;

import java.util.List;

public class WinningLottoNumbersValidator extends SystemValidator {
    public static void validateWinningLottoNumbers(List<Integer> numbers){
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

    private static void displayMessageAndThrowException(WinningCombinationInputErrorMessage message){
        message.displayMessage();
        throw new IllegalArgumentException(message.getMessage());
    }

}
