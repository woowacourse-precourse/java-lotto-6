package lotto.Message;

import static lotto.config.LottoConfig.AMOUNT_VALUE_MIN;
import static lotto.config.LottoConfig.AMOUNT_VALUE_MAX;

public enum ErrorMessage {
    AMOUNT_RANGE_ERROR_MESSAGE(String.format("[ERROR]입력 값은 %d ~ %d 사이 숫자여야 합니다."
            , AMOUNT_VALUE_MIN.getValue(), AMOUNT_VALUE_MAX.getValue())),
    AMOUNT_UNIT_ERROR_MESSAGE(String.format("[ERROR]입력 값은 %d단위 숫자여야 합니다."
            , AMOUNT_VALUE_MIN.getValue()));

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
