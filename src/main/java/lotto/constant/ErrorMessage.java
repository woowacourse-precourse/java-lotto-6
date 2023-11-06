package lotto.constant;

import static lotto.constant.Config.PRICE_PER_LOTTO;

public class ErrorMessage {
    public static final String PREFIX = "[ERROR] ";
    public static final String PRICE_NOT_NUMERIC = "금액은 숫자 형식 이어야 합니다.";
    public static final String PRICE_NEGATIVE = "금액은 0 또는 양수 이어야 합니다.";
    public static final String PRICE_NOT_DIVIDED = String.format("금액은 %d으로 나누어 떨어져야 합니다.", PRICE_PER_LOTTO);
}
