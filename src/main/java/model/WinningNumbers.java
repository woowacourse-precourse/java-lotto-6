package model;

import Constant.ErrorMessage;
import java.util.List;

public class WinningNumbers extends Lotto {
    private int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers) {
        super(winningNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_OF_NUMBERS.getMessage());
        }
    }
}