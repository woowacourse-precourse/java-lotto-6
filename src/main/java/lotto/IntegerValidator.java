package lotto;

import static Constant.GuideMessagePiece.EMPTY_VALUE;

public class IntegerValidator {

    private static final String ERROR_MSG_INPUT_ZERO_OR_POSITIVE_INTEGER = "[ERROR] 0 혹은 양의 정수만 입력해 주세요.";
    private static final String ERROR_MSG_INPUT_NOT_EMPTY_VALUE = "[ERROR] 하나 이상의 값을 입력해야 합니다.";

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

    public static void checkWinnigNumbersValue(String value)throws IllegalArgumentException{
        return;
    }

    public static void checkBonusNumberValue(String value)throws IllegalArgumentException{
        return;
    }

}
