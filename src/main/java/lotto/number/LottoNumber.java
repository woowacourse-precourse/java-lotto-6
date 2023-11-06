package lotto.number;

import lotto.enums.ErrorMessage;
import lotto.exception.InvalidValueException;
import lotto.lotto.Lotto;

public class LottoNumber extends Number {

    private boolean isBonus;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public static LottoNumber pickBonusNumber(String value){
        return new LottoNumber(value, true);
    }

    public static LottoNumber pickNormalNumber(String value){
        return new LottoNumber(value, false);
    }

    public static LottoNumber fromAutoLotto(int value){
        return new LottoNumber(value, false);
    }

    private LottoNumber(String value, boolean isBonus){
        validateIsIntegerValue(value);
        validateNumberValue(value);
        super.value = Integer.parseInt(value);
        this.isBonus = isBonus;
    }

    private LottoNumber(int value, boolean isBonus){
        validateNumberValue(value);
        super.value = value;
        this.isBonus = isBonus;
    }

    private void validateNumberValue(String value){
        int intValue = Integer.parseInt(value);
        if (intValue > MAX_VALUE || intValue < MIN_VALUE){
            throw new InvalidValueException(ErrorMessage.INVALID_NUMBER_VALUE);
        }
    }


    private void validateNumberValue(int value){
        if (value > MAX_VALUE || value < MIN_VALUE){
            throw new InvalidValueException(ErrorMessage.INVALID_NUMBER_VALUE);
        }
    }

    private void validateIsIntegerValue(String value){
        if (!Character.isDigit(value.charAt(0))){
            throw new InvalidValueException(ErrorMessage.INVALID_STRING_INPUT);
        }
    }
}
