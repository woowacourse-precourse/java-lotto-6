package lotto.domain;

import lotto.type.ConstNumberType;
import lotto.type.ErrorMessageType;

import java.util.regex.Pattern;

public class BonusLottoNumber {
    private int bonusNum;

    public BonusLottoNumber(String bonus) {
        this.bonusNum = inputBonusException(bonus);
    }
    
    // 입력된 보너스 숫자에 대한 예외 처리
    public int inputBonusException(String bonus) {
        if (!Pattern.matches("^[1-9][0-9]*$", bonus)) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_NUMBER.message());
        }
        int bonusNum = Integer.parseInt(bonus);
        if (bonusNum < ConstNumberType.LOTTO_START_NUMBER.number()
                || bonusNum > ConstNumberType.LOTTO_END_NUMBER.number()) {
            throw new IllegalArgumentException(ErrorMessageType.OUT_OF_LOTTO_NUMERICAL_RANGE.message());
        }
        return bonusNum;
    }

    public int getBounsNum() {
        return this.bonusNum;
    }
}
