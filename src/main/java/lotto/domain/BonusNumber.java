package lotto.domain;

import java.util.List;
import lotto.validator.ValidatorLottoNumber;

public class BonusNumber {
    private int number;

    private BonusNumber(int bonusNumber) {
        this.number = bonusNumber;
    }

    public static BonusNumber fromStringWitValidateWinningNumber(String bonusNumber, List<Integer> winnerNumber) {
        ValidatorLottoNumber.validateBonusNumber(bonusNumber, winnerNumber);
        return new BonusNumber(Integer.parseInt(bonusNumber));
    }

    public int getBonusNumber() {
        return number;
    }
}
