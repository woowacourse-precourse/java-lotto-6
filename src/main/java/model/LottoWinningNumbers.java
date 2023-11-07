package model;

import java.util.List;
import utils.Converter;
import utils.NumberValidation;

public class LottoWinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;
    private static final String DUPLICATION_BONUS_AND_WINNING = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";

    public LottoWinningNumbers(Lotto winningNumbers, String bonusNumber) {
        this.winningNumbers = winningNumbers;
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
            throw new IllegalArgumentException(DUPLICATION_BONUS_AND_WINNING);
        }
    }
}
