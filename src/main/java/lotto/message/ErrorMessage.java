package lotto.message;

import static lotto.configuration.InputFormatConfig.LOTTO_PRICE;
import static lotto.configuration.RandomNumberConfig.*;

public class ErrorMessage {
    public static final String ERROR_MESSAGE_HEAD = "[ERROR] ";
    public static final String INVALID_MONEY_INPUT_EXCEPTION
            = "구입금액은 " + LOTTO_PRICE + "원 단위의 양의 정수 값만 입력할 수 있습니다. 예 : "
            + LOTTO_PRICE + ", " + LOTTO_PRICE * 20 + ", " + LOTTO_PRICE * 300;
    public static final String INVALID_NUMBER_SIZE_EXCEPTION
            = "로또 번호의 개수는 " + COUNT + "개여야 합니다. 전송된 개수 : ";
    public static final String DUPLICATE_NUMBER_EXCEPTION = "중복된 숫자가 존재합니다. ";
    public static final String NUMBER_INDICATION = "번째 숫자 : ";
    public static final String NUMBER_OUT_OF_RANGE_EXCEPTION
            = "로또 번호는 " + START_INCLUSIVE + "부터 " + END_INCLUSIVE + "사이의 숫자여야 합니다. 유효하지 않은 로또 번호 : ";
    public static final String INVALID_NUMBERS_ORDER_EXCEPTION = "로또 번호들이 오름차순으로 정렬되어 있지 않습니다. ";
}
