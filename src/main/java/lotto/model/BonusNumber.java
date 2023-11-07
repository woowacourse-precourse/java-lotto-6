package lotto.model;

import lotto.exception.business.BusinessConditionException;

import static lotto.constant.LottoConfig.LOTTO_END_NUMBER;
import static lotto.constant.LottoConfig.LOTTO_START_NUMBER;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < LOTTO_START_NUMBER.getValue() || number > LOTTO_END_NUMBER.getValue()) {
            throw new BusinessConditionException("숫자 범위가 1~45여야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
