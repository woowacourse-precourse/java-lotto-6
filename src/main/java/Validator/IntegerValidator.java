package Validator;

import static Constant.GuideMessagePiece.EMPTY_VALUE;

public class IntegerValidator {

    private static final String ERROR_MSG_INPUT_ZERO_OR_POSITIVE_INTEGER = "[ERROR] 0 혹은 양의 정수만 입력해 주세요.";
    private static final String ERROR_MSG_INPUT_NOT_EMPTY_VALUE = "[ERROR] 하나 이상의 값을 입력해야 합니다.";
    private static final String ERROR_MSG_INPUT_UNDER_INTEGER_RANGE = "[ERROR] 2147483647 이하의 숫자를 입력해 주세요.";

    public static void checkEmptyValue(String value) throws IllegalArgumentException{
        if(EMPTY_VALUE.equals(value)){
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
        String maxValue = EMPTY_VALUE+Integer.MAX_VALUE;
        if(isFirstBiggerThanSecond(value,maxValue)){
            throw new IllegalArgumentException(ERROR_MSG_INPUT_UNDER_INTEGER_RANGE);
        }
        return;
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
