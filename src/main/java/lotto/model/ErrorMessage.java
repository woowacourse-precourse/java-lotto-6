package lotto.model;

import static lotto.model.Lotto.LOTTO_MAX_NUMBER;
import static lotto.model.Lotto.LOTTO_MIN_NUMBER;
import static lotto.model.Lotto.LOTTO_SIZE;
import static lotto.model.Money.CURRENT_UNIT;

public enum ErrorMessage {

    INPUT_POSITIVE_ERROR("[ERROR] 양의 정수만 입력해주세요."),
    BONUS_DUPLICATE_ERROR("[ERROR] 보너스 숫자는 당첨 번호에 포함되지 않은 숫자를 선택해야 합니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 숫자는 " + LOTTO_MIN_NUMBER + "이상 " + LOTTO_MAX_NUMBER + "이하인 값만 입력하세요"),
    LOTTO_WRONG_SIZE_ERROR("[ERROR] " + LOTTO_SIZE + "개의 숫자를 입력하세요."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 중복하지 않는 숫자만 입력해주세요."),
    MONEY_UNIT_ERROR("[ERROR] 금액은 " + CURRENT_UNIT + "으로 나누어 떨어져야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
