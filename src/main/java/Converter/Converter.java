package Converter;

import static Constant.GuideMessagePiece.COMMA;
import static Constant.LottoSettingValue.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Validator.IntegerValidator;
import lotto.Lotto;
import Validator.MoneyValidator;

public class Converter {

    public static String convertCommaStringToString(String commaValue){
        String result = "";
        for (String splitValue : commaValue.split(COMMA)) {
            result += splitValue;
        }
        return result;
    }

    public static Lotto convertCommaStringToLotto(String commaValue) throws IllegalArgumentException{
        List<Integer> numbers = new ArrayList<>(LOTTO_SIZE);
        for(String splitValue : commaValue.split(COMMA)){
            Integer number = convertStringToPositiveInteger(splitValue);
            numbers.add(number);
        }
        Collections.sort(numbers);
        return new Lotto(Collections.unmodifiableList(numbers));
    }

    public static Lotto convertListIntToLotto(List<Integer> value){
        List<Integer> randomNumbers = new ArrayList<Integer>(value);
        Collections.sort(randomNumbers);
        return new Lotto(Collections.unmodifiableList(randomNumbers));
    }

    public static Integer convertStringToMoney(String value)throws IllegalArgumentException{
        Integer money = convertStringToPositiveInteger(value);
        MoneyValidator.isDividedInto1000(money);
        return money;
    }

    /* include 0 */
    public static Integer convertStringToPositiveInteger(String value) throws IllegalArgumentException{
        IntegerValidator.checkEmptyValue(value);
        IntegerValidator.checkZeroOrPositiveInteger(value);
        IntegerValidator.checkIntegerMaxValue(value);
        return Integer.valueOf(value);
    }

}
