package lotto.model;

import lotto.validation.ErrorMessage;

import static lotto.model.constant.LottoConstant.*;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {

        this.bonusNumber = bonusNumber;
    }

    public static void validateBonusNumberRange(int bonusNumber) {
        if(bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
