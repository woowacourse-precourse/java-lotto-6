package lotto;

public class IntegerValidator {

    private static final String ERROR_MSG_INPUT_ZERO_OR_POSITIVE_INTEGER = "[ERROR] 0 혹은 양의 정수만 입력해 주세요.";

    public static void isZeroOrPositiveInteger(String value) throws IllegalArgumentException{
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
