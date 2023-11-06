package lotto.constant.message;

import static lotto.constant.SystemData.PURCHASE_AMOUNT_UNIT;
import static lotto.constant.SystemData.MIN_IN_NUMBER;
import static lotto.constant.SystemData.MAX_IN_NUMBER;

public class ErrorMessage {
    private static final String prefix = "[ERROR] ";
    public static final String NUMBER_FORMAT_ERROR = prefix + "숫자만 입력 가능합니다.";
    public static final String DUPLICATE_NUMBER = prefix + "중복되는 숫자입니다.";
    public static final String INVALID_PURCHASE_AMOUNT
           = prefix + String.format("%d원 단위의 금액만 입력 가능합니다.", PURCHASE_AMOUNT_UNIT);
    public static final String INVALID_LOTTO_NUMBER_RANGE
            = prefix + String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_IN_NUMBER, MAX_IN_NUMBER);
}
