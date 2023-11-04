package lotto.Message;

import static lotto.config.LottoConfig.AMOUNT_VALUE_MIN;
import static lotto.config.LottoConfig.AMOUNT_VALUE_MAX;
import static lotto.config.LottoConfig.LOTTO_VALUE_MIN;
import static lotto.config.LottoConfig.LOTTO_VALUE_MAX;
import static lotto.config.LottoConfig.LOTTO_VALUE_SIZE;

public enum ErrorMessage {
    AMOUNT_RANGE_ERROR_MESSAGE(String.format("[ERROR]구입금액 값은 %d ~ %d 사이 숫자여야 합니다."
            , AMOUNT_VALUE_MIN.getValue(), AMOUNT_VALUE_MAX.getValue())),
    AMOUNT_UNIT_ERROR_MESSAGE(String.format("[ERROR]구입금액 값은 %d단위 숫자여야 합니다."
            , AMOUNT_VALUE_MIN.getValue())),
    LOTTO_RANGE_ERROR_MESSAGE(String.format("[ERROR]당첨 번호 값은 %d ~ %d 사이 숫자여야 합니다."
            , LOTTO_VALUE_MIN.getValue(), LOTTO_VALUE_MAX.getValue())),
    LOTTO_SIZE_ERROR_MESSAGE(String.format("[ERROR]당첨 번호는 %d자리 여야 합니다."
            , LOTTO_VALUE_SIZE.getValue()));
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
