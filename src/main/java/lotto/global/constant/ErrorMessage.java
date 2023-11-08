package lotto.global.constant;

import static lotto.global.constant.Game.LOTTO_PRICE;

public class ErrorMessage {
    public static final String ERROR = "[ERROR] ";
    public static final String AMOUNT_FORMAT_ERROR_MESSAGE = ERROR + "구매 금액은 숫자여야 합니다.";
    public static final String AMOUNT_MULTIPLE_ERROR_MESSAGE = ERROR + "로또는 " + LOTTO_PRICE + "원의 배수로만 구매 가능합니다.";
    public static final String TRIAL_FORMAT_ERROR_MESSAGE = ERROR + "0 이상의 숫자만 입력 가능합니다.";
}
