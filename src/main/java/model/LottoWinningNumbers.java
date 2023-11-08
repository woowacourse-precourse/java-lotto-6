package model;

import java.util.List;
import message.ErrorMessages;
import utils.Converter;
import utils.NumberValidation;

public class LottoWinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoWinningNumbers(List<Integer> winningNumbers, String bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        validationBonusNumber(Converter.stringToInt(bonusNumber));
        this.bonusNumber = Converter.stringToInt(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validationBonusNumber(int bonusNumber) {
        NumberValidation.isOverMaxNumber(bonusNumber);
        NumberValidation.isUnderMinNumber(bonusNumber);
        duplicationBonusNumber(bonusNumber);
    }

    public void duplicationBonusNumber(int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATION_BONUS_AND_WINNING);
        }
    }
}
