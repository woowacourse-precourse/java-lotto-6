package lotto.validator.system.domain;

import lotto.validator.system.SystemValidator;
import lotto.view.message.exception.LottoGenerateErrorMessage;

import java.util.List;

public class LottoValidator extends SystemValidator {
    public static void validateLotto(List<Integer> numbers){
        if(isSizeWrong(numbers)){
            displayMessageAndThrowException(LottoGenerateErrorMessage.INCORRECT_SIZE);
        }
        if(isOutOfRangeLottoNumbers(numbers)){
            displayMessageAndThrowException(LottoGenerateErrorMessage.OUT_OF_RANGE_NUMBER);
        }
        if(isDuplicate(numbers)){
            displayMessageAndThrowException(LottoGenerateErrorMessage.DUPLICATED_NUMBER);
        }
    }

    private static void displayMessageAndThrowException(LottoGenerateErrorMessage message){
        message.displayMessage();
        throw new IllegalArgumentException(message.getMessage());
    }
}
