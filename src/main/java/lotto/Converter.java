package lotto;

import static Constant.GuideMessagePiece.COMMA;
import static Constant.LottoSettingValue.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static String convertCommaStringToString(String commaValue){
        String result = "";
        for (String splitedValue : commaValue.split(COMMA)) {
            result += splitedValue;
        }
        return result;
    }

    public static List<Integer> convertCommaStringToListInt(String commaValue){
        List<Integer> winnigNumbers = new ArrayList<>(LOTTO_SIZE);
        for(String number : commaValue.split(COMMA)){
            winnigNumbers.add(Integer.valueOf(number));
        }
        return winnigNumbers;
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
