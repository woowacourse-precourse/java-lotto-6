package lotto.model;

import lotto.util.validator.constant.ErrorMessageConstant;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, WinningNumber winningNumber) {
        validate(bonusNumber, winningNumber.getWinningNumbers());
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, List<Integer> winningNumbers) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessageConstant.BONUS_NUMBER_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}
