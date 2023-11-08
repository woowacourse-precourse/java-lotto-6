package lotto.domain;

import lotto.type.ErrorMessageType;

public class BonusLottoNumber {
    private int bonusNum;

    public BonusLottoNumber(String bonus) {
        int bonusNum = inputBonusException(bonus);
    }

    private int inputBonusException(String bonus) {
        if (bonus.matches("[0-9]+") == false) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_NUMBER.message());
        }
        int bonusNum = Integer.parseInt(bonus);
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException(ErrorMessageType.OUT_OF_LOTTO_NUMERICAL_RANGE.message());
        }
        return bonusNum;
    }
    public int getBounsNum() {
        return bonusNum;
    }
}
