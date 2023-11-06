package lotto.validator.system;

import lotto.view.message.exception.LottoGenerateErrorMessage;

import java.util.List;

public class LottoValidator extends SystemValidator{
    public static void validateLotto(List<Integer> numbers){
        if(isSizeWrong(numbers)){
            throw new IllegalArgumentException(LottoGenerateErrorMessage.INCORRECT_SIZE.getMessage());
        }
        if(isOutOfRangeLottoNumbers(numbers)){
            throw new IllegalArgumentException(LottoGenerateErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
        if(isDuplicate(numbers)){
            throw new IllegalArgumentException(LottoGenerateErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }
}
