package lotto.domain;

import static lotto.domain.constant.ErrorConst.LOTTO_OUT_OF_RANGE;
import static lotto.domain.constant.LottoNumberConst.HIGHEST_NUMBER;
import static lotto.domain.constant.LottoNumberConst.LOWEST_NUMBER;

public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (bonusNumber < LOWEST_NUMBER || bonusNumber > HIGHEST_NUMBER) {
            throw new IllegalArgumentException(LOTTO_OUT_OF_RANGE);
        }
    }
}
