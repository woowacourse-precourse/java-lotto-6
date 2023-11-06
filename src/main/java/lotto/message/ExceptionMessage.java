package lotto.message;

import lotto.constant.ConstantValue;

public class ExceptionMessage {

    public static final String INPUT_OUT_OF_RANGE = "[ERROR] 범위에서 벗어난 값을 입력할 수 없습니다.";
    public static final String INPUT_NOT_INTEGER = "[ERROR] 숫자 이외에는 입력할 수 없습니다.";
    public static final String INPUT_NOT_DIVISIBLE = "[ERROR] " + ConstantValue.LOTTO_PRICE + "원의 배수만 입력할 수 있습니다.";
    public static final String INPUT_NOT_POSITIVE = "[ERROR] 양수만 입력할 수 있습니다.";
    public static final String INPUT_NOT_DISTINCT = "[ERROR] 중복된 값을 입력할 수 없습니다.";
    public static final String NUMBER_SIZE_NOT_MATCH = "[ERROR] " + ConstantValue.LOTTO_NUMBERS_SIZE + " 개의 숫자를 입력해 주세요";
}
