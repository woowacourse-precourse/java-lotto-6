package lotto.util;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.view.ErrorMessage.*;
import static lotto.constant.LottoNumberComposition.*;

public class BonusValidator {
    public void validateBonusNumber(int bonusNum) {
        validateBonusRange(bonusNum);
        validateBonusCount(bonusNum);
        validateBonusBlank(bonusNum);
        validateBonusDuplicate(bonusNum);
    }


    private void validateBonusCount(int bonusNum) {
        String bonusStr = String.valueOf(bonusNum);
        if (bonusStr.length() != ENTER_BONUS_COUNT.getNumber()) {
            throw new IllegalArgumentException(BONUS_COUNT.getMessage());
        }
    }

    private void validateBonusRange(int bonusNum) {
        if (bonusNum < START_NUMBER.getNumber() || bonusNum > END_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NUMBER_RANGE.getMessage());
        }
    }

    private void validateBonusBlank(int bonusNum) {
        String bonusStr = String.valueOf(bonusNum);
        if (bonusStr.contains(" ")) {
            throw new IllegalArgumentException(NOT_BLANK.getMessage());
        }
    }

    private List<Integer> winningNumbers = new ArrayList<>();

    public void addWinningNumber(String number) {
        winningNumbers.add(Integer.parseInt(number));
    }

    private void validateBonusDuplicate(int bonusNum) {
        if (winningNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE.getMessage());
        }
    }
}
