package lotto.message;

import static lotto.constant.ConstantValue.*;

public class ExceptionMessage {

    private static final String ERROR_MESSAGE = "[ERROR]";
    public static final String INPUT_OUT_OF_RANGE = ERROR_MESSAGE +
            START_INCLUSIVE + " ~ " + END_INCLUSIVE +"의 범위에서 벗어난 값을 입력할 수 없습니다.";
    public static final String INPUT_NOT_INTEGER = ERROR_MESSAGE + " 정수 이외에는 입력할 수 없습니다.";
    public static final String INPUT_NOT_DIVISIBLE = ERROR_MESSAGE + LOTTO_PRICE + "원의 배수만 입력할 수 있습니다.";
    public static final String INPUT_NOT_POSITIVE = ERROR_MESSAGE + " 양수만 입력할 수 있습니다.";
    public static final String INPUT_NOT_DISTINCT = ERROR_MESSAGE + " 중복된 값을 입력할 수 없습니다.";
    public static final String NUMBER_SIZE_NOT_MATCH = ERROR_MESSAGE + ",로 구분된 " + LOTTO_NUMBERS_SIZE + "개의 숫자를 입력해 주세요";
}
