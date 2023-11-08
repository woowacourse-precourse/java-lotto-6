package lotto.domain;

import lotto.type.ErrorMessageType;

import java.util.regex.Pattern;

public class BonusLottoNumber {
    private int bonusNum;

    public BonusLottoNumber(String bonus) {
        this.bonusNum = inputBonusException(bonus);
    }

    public int inputBonusException(String bonus) {
        if (!Pattern.matches("^[1-9][0-9]*$", bonus)) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_NUMBER.message());
        }
        int bonusNum = Integer.parseInt(bonus);
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException(ErrorMessageType.OUT_OF_LOTTO_NUMERICAL_RANGE.message());
        }
        return bonusNum;
    }
    public int getBounsNum() {
        return this.bonusNum;
    }
}
