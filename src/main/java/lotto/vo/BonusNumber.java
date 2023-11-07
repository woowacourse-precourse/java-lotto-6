package lotto.vo;

import lotto.domain.WinningChecker;
import lotto.values.CorrectNumber;

import java.util.List;

import static lotto.values.CorrectNumber.SECOND_PLACE;
import static lotto.values.CorrectNumber.THIRD_PLACE;
import static lotto.values.ExceptionMessage.*;
import static lotto.values.LottoInformation.*;

public class BonusNumber {
    int bonusNumber;

    public BonusNumber(String bonusNumber, WinningNumber winningNumber) {
        checkException(bonusNumber);
        checkNotInWinnerNumber(winningNumber);
    }

    public void checkException(String number) {
        if (number.length() == 0) {
            throw new IllegalArgumentException(NOT_NULL.getMessage());
        }
        if (!number.matches(ONLY_NUMBER.getMessage())) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }

        int num = Integer.parseInt(number);
        if (num < START_LOTTO_NUMBER.getValue() || num > LAST_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(NOT_IN_NUMBER_RANGE.getMessage());
        }

        bonusNumber = num;
    }

    public void checkNotInWinnerNumber(WinningNumber w){
        if(w.checkDuplication(bonusNumber))
            throw new IllegalArgumentException(BONUS_NUMBER_IN_WINNING_NUMBER.getMessage());
    }

    public CorrectNumber compareLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(bonusNumber)) return SECOND_PLACE;
        return THIRD_PLACE;
    }
}
