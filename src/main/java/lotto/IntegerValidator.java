package lotto;

import static Constant.GuideMessagePiece.EMPTY_VALUE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerValidator {

    private static final String ERROR_MSG_INPUT_ZERO_OR_POSITIVE_INTEGER = "[ERROR] 0 혹은 양의 정수만 입력해 주세요.";
    private static final String ERROR_MSG_INPUT_NOT_EMPTY_VALUE = "[ERROR] 하나 이상의 값을 입력해야 합니다.";
    private static final String ERROR_MSG_INPUT_INTEGER_RANGE_OVER = "[ERROR] 2147483647원 이하의 금액을 입력해 주세요.";

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
        String intMaxValue = EMPTY_VALUE+Integer.MAX_VALUE;
        List<String> maxValues = new ArrayList<String>();
        maxValues.add(value);
        maxValues.add(intMaxValue);
        Collections.sort(maxValues);
        if(intMaxValue.equals(maxValues.get(0))){
            if(intMaxValue.equals(maxValues.get(1))){
                return;
            }
            throw new IllegalArgumentException(ERROR_MSG_INPUT_INTEGER_RANGE_OVER);
        }
    }

    public static void checkWinnigNumbersValue(String value)throws IllegalArgumentException{
        return;
    }

    public static void checkBonusNumberValue(String value)throws IllegalArgumentException{
        return;
    }

}
