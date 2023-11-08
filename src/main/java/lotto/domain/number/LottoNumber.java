package lotto.domain.number;

import java.util.Objects;
import lotto.global.enums.ErrorMessage;
import lotto.global.exception.InvalidValueException;

public class LottoNumber extends Number  {

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

    public boolean isBonus(){
        return this.isBonus;
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

    @Override
    public String toString(){
        return String.valueOf(super.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        if (!super.equals(o)) return false;
        LottoNumber that = (LottoNumber) o;
        return isBonus == that.isBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isBonus);

    }

}
