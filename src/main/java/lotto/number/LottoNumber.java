package lotto.number;

import lotto.enums.ErrorMessage;
import lotto.exception.InvalidValueException;

public class LottoNumber extends Number {

    private boolean isBonus;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public static LottoNumber pickBonusNumber(int value){
        return new LottoNumber(value, true);
    }

    public static LottoNumber pickNormalNumber(int value){
        return new LottoNumber(value, false);
    }

    public static LottoNumber fromAutoLotto(int value){
        return new LottoNumber(value, false);
    }

    private LottoNumber(int value, boolean isBonus){
        validateNumberValue(value);
        super.value = value;
        this.isBonus = isBonus;
    }

    private void validateNumberValue(int value){
        if (value > MAX_VALUE || value < MIN_VALUE){
            throw new InvalidValueException(ErrorMessage.INVALID_NUMBER_VALUE);
        }
    }
}
