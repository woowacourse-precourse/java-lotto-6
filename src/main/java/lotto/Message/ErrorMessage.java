package lotto.Message;

import static lotto.config.LottoConfig.AMOUNT_VALUE_MIN;
import static lotto.config.LottoConfig.AMOUNT_VALUE_MAX;
import static lotto.config.LottoConfig.LOTTO_VALUE_MIN;
import static lotto.config.LottoConfig.LOTTO_VALUE_MAX;
import static lotto.config.LottoConfig.LOTTO_VALUE_SIZE;

public enum ErrorMessage {
    AMOUNT_RANGE_ERROR_MESSAGE(String.format("[ERROR] 구입금액 값은 %d ~ %d 사이 숫자여야 합니다."
            , AMOUNT_VALUE_MIN.getValue(), AMOUNT_VALUE_MAX.getValue())),
    AMOUNT_UNIT_ERROR_MESSAGE(String.format("[ERROR] 구입금액 값은 %d단위 숫자여야 합니다."
            , AMOUNT_VALUE_MIN.getValue())),
    LOTTO_RANGE_ERROR_MESSAGE(String.format("[ERROR] 당첨 번호 값은 %d ~ %d 사이 숫자여야 합니다."
            , LOTTO_VALUE_MIN.getValue(), LOTTO_VALUE_MAX.getValue())),
    LOTTO_SIZE_ERROR_MESSAGE(String.format("[ERROR] 당첨 번호는 %d자리 여야 합니다."
            , LOTTO_VALUE_SIZE.getValue())),
    LOTTO_IS_DUPLICATE("[ERROR] 당첨 번호가 중복 입니다."),
    BONUS_LOTTO_IS_DUPLICATE("[ERROR] 보너스 번호가 중복 입니다."),
    OBJECT_IS_NULL("[ERROR] Null"),
    VALUE_IS_NOT_CONVERT_INTEGER("[ERROR] 입력 값을 정수로 바꿀 수 없습니다. 정수로 입력해 주세요.");
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
