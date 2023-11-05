package lotto.controller;

import lotto.domain.WinningNumbers;
import lotto.domain.constants.ExceptionMessage;
import lotto.validator.Validator;

import java.util.List;

public class BonusNumberDuplicationValidator implements Validator<Integer> {
    private WinningNumbers winningNumbers;

    public void getWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void validate(Integer inputNumber) {
        if (winningNumbers.hasNumber(inputNumber)) {
            throwException(ExceptionMessage.BONUS_NUMBER_DUPLICATION_WITH_WINNING_NUMBERS.getMessage());
        }
    }
}
