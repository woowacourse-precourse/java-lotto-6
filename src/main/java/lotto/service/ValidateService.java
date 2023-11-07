package lotto.service;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;

public class ValidateService {
    public int validateNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
        }
    }


    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicationWinningNumbersAndBonusNumber(bonusNumber, winningNumbers);
    }


    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoNumber.START_NUMBER.getNumber() || bonusNumber > LottoNumber.END_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_OVER_RANGE_ERROR.getMessage());
        }

    }


    private void validateDuplicationWinningNumbersAndBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
        }
    }

}
