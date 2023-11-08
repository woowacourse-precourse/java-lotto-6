package lotto.validator.system;

import lotto.domain.BonusNumber;
import lotto.domain.WinningCombination;
import lotto.domain.WinningLottoNumbers;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;

import java.util.List;

public class WinningCombinationValidator extends SystemValidator{
    public static void validateWinningNumbers(List<Integer> numbers){
        if(isSizeWrong(numbers)){
            WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.displayMessage();
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.INCORRECT_SIZE.getMessage());
        }
        if(isOutOfRangeLottoNumbers(numbers)){
            WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.displayMessage();
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
        if(isDuplicate(numbers)){
            WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.displayMessage();
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    public static void validateWinningCombination(WinningLottoNumbers winningLottoNumbers, BonusNumber bonusNumber){
        if(isDuplicateBonusNumber(winningLottoNumbers,bonusNumber.getBonusNumber())){
            WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.displayMessage();
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    public static void validateBonusNumber(int bonusNumber){
        if(isOutOfRangeBonusNumber(bonusNumber)){
            WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.displayMessage();
            throw new IllegalArgumentException(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }
}
