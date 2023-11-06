package lotto.domain;

import static lotto.util.LottoUtil.verifyRangeOfLottoNumber;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = validateBonusNumber(bonusNumber);
    }

    private static int validateBonusNumber(int number) {
        verifyRangeOfLottoNumber(number);
        return number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
