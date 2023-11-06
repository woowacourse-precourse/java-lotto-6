package lotto.domain.message;

import static lotto.domain.lotto.LottoRule.*;

import lotto.domain.lotto.LottoRule;

public enum ErrorMessage {

    ERROR("[ERROR] "),
    NUMBER_RANGE_EXCEPTION_MESSAGE("숫자는" + LOTTO_MIN_NUMBER_INCLUSION.getValue() + "과"
            + LOTTO_MAX_NUMBER_INCLUSION.getValue() + "사이 여야 합니다"),
    NUMBERS_SIZE_EXCEPTION_MESSAGE("숫자의 개수는" + LOTTO_NUMBER_COUNT.getValue() + "개여야 합니다."),
    DUPLICATION_EXCEPTION_MESSAGE("번호끼리 중복이 있으면 안됩니다."),
    PRICE_EXCEPTION_MESSAGE("Money는" + LOTTO_PRICE.getValue() + "단위어야 합니다");
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR.message + message;
    }
}
