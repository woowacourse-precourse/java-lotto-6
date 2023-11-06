package lotto.validator.system;

import lotto.domain.WinningLottoNumbers;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;

import java.util.List;

public class WinningCombinationValidator extends SystemValidator{
    public static void validateWinningNumbers(List<Integer> numbers){
        if(isSizeWrong(numbers)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.INCORRECT_SIZE.getMessage());
        }
        if(isOutOfRangeLottoNumbers(numbers)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
        if(isDuplicate(numbers)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    public static void validateWinningCombination(WinningLottoNumbers winningLottoNumbers, int bonusNumber){
        if(isOutOfRangeBonusNumber(bonusNumber)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
        if(isDuplicateBonusNumber(winningLottoNumbers,bonusNumber)){
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }
}
