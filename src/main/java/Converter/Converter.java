package Converter;

import static Constant.GuideMessagePiece.COMMA;
import static Constant.LottoSettingValue.LOTTO_SIZE;

import Validator.IntegerValidator;
import Validator.MoneyValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class Converter {

    public static String commaStringToString(String commaValue){
        String result = "";
        for (String splitValue : commaValue.split(COMMA)) {
            result += splitValue;
        }
        return result;
    }

    public static Lotto commaStringToLotto(String commaValue) throws IllegalArgumentException{
        List<Integer> numbers = new ArrayList<>(LOTTO_SIZE);
        for(String splitValue : commaValue.split(COMMA)){
            Integer number = stringToLottoNumber(splitValue);
            numbers.add(number);
        }
        return listIntToLotto(numbers);
    }

    public static Lotto listIntToLotto(List<Integer> value){
        List<Integer> randomNumbers = new ArrayList<Integer>(value);
        Collections.sort(randomNumbers);
        return new Lotto(Collections.unmodifiableList(randomNumbers));
    }

    public static Integer stringToLottoNumber(String value){
        IntegerValidator.checkEmptyValue(value);
        IntegerValidator.checkZeroOrPositiveInteger(value);
        IntegerValidator.checkLottoNumberRange(value);
        return Integer.valueOf(value);
    }

    public static Integer stringToMoney(String value)throws IllegalArgumentException{
        Integer money = stringToPositiveInteger(value);
        MoneyValidator.isDividedInto1000(money);
        return money;
    }

    /* include 0 */
    public static Integer stringToPositiveInteger(String value) throws IllegalArgumentException{
        IntegerValidator.checkEmptyValue(value);
        IntegerValidator.checkZeroOrPositiveInteger(value);
        IntegerValidator.checkIntegerMaxValue(value);
        return Integer.valueOf(value);
    }

}
