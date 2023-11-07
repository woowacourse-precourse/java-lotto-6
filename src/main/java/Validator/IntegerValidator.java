package Validator;

import static Constant.ErrorMessage.ERROR_MSG_INPUT_LOTTO_NUMBER_RANGE;
import static Constant.GuideMessagePiece.EMPTY_STRING_VALUE;
import static Constant.LottoSettingValue.LOTTO_MAXIMUM_NUMBER;
import static Constant.LottoSettingValue.LOTTO_MINIMAL_NUMBER;

public class IntegerValidator {

    private static final String ERROR_MSG_INPUT_ZERO_OR_POSITIVE_INTEGER = "[ERROR] 0 혹은 양의 정수만 입력해 주세요.";
    private static final String ERROR_MSG_INPUT_NOT_EMPTY_VALUE = "[ERROR] 하나 이상의 값을 입력해야 합니다.";
    private static final String ERROR_MSG_INPUT_UNDER_INTEGER_RANGE = "[ERROR] 2147483647 이하의 숫자를 입력해 주세요.";

    public static void checkEmptyValue(String value) throws IllegalArgumentException{
        if(EMPTY_STRING_VALUE.equals(value)){
            throw new IllegalArgumentException(ERROR_MSG_INPUT_NOT_EMPTY_VALUE);
        }
    }

    public static void checkZeroOrPositiveInteger(String value) throws IllegalArgumentException{
        for (char oneValue : value.toCharArray()) {
            if(oneValue < '0' || oneValue > '9'){
                throw new IllegalArgumentException(ERROR_MSG_INPUT_ZERO_OR_POSITIVE_INTEGER);
            }
        }
        return;
    }

    public static void checkIntegerMaxValue(String value) throws IllegalArgumentException{
        String maxValue = EMPTY_STRING_VALUE+Integer.MAX_VALUE;
        if(isFirstBiggerThanSecond(value,maxValue)){
            throw new IllegalArgumentException(ERROR_MSG_INPUT_UNDER_INTEGER_RANGE);
        }
        return;
    }

    public static void checkLottoNumberRange(String value) throws IllegalArgumentException {
        if(isFirstBiggerThanSecond(LOTTO_MINIMAL_NUMBER+EMPTY_STRING_VALUE,value)
                || isFirstBiggerThanSecond(value,LOTTO_MAXIMUM_NUMBER+EMPTY_STRING_VALUE)){
            throw new IllegalArgumentException(ERROR_MSG_INPUT_LOTTO_NUMBER_RANGE);
        }
    }

    private static Boolean isFirstBiggerThanSecond(String value1, String value2){
        if (value1.length() > value2.length()) {
            return true;
        }
        if (value1.length() < value2.length()) {
            return false;
        }

        for (Integer index = 0; index <= value1.length(); index++) {
            if(value1.charAt(index) > value2.charAt(index)){
                return true;
            }
            if(value1.charAt(index) < value2.charAt(index)){
                return false;
            }
        }
        return false;
    }

}
