package lotto.winningLotto.domain;

import java.util.List;
import lotto.Positive;
import lotto.util.LottoConstant;

public class LottoBonusNumber {
    private Positive bonusNumber;

    public LottoBonusNumber(Positive bonusNumber) {
        validateBlank(bonusNumber);
        validateOutOfRangeOneToFortyFive(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getNumber() {
        return bonusNumber.getNumber();
    }

    private void validateBlank(Positive number) {
        if (number == null) {
            throw new NullPointerException();
        }
    }

    private void validateOutOfRangeOneToFortyFive(Positive number) {
            checkOutOfRangeRangeOneToFortyFive(number.getNumber());

    }

    private void checkOutOfRangeRangeOneToFortyFive(int number) {
        if (number < LottoConstant.BEGIN_NUMBER || number > LottoConstant.LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
