package lotto.global.constant;

import static lotto.global.constant.Game.LOTTO_PRICE;

public class ErrorMessage {
    public static final String ERROR = "[ERROR] ";
    public static final String AMOUNT_FORMAT_ERROR_MESSAGE = ERROR + "구매 금액은 숫자여야 합니다.";
    public static final String AMOUNT_MULTIPLE_ERROR_MESSAGE = ERROR + "로또는 " + LOTTO_PRICE + "원의 배수로만 구매 가능합니다.";
    public static final String LOTTO_SIZE_ERROR_MESSAGE = ERROR + "로또는 6개의 숫자로 이루어져야 합니다.";
    public static final String LOTTO_DUPLICATION_ERROR_MESSAGE = ERROR + "로또는 6개의 중복되지 않은 숫자로 이루어져야 합니다.";

}
