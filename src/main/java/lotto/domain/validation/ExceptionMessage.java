package lotto.domain.validation;

import static lotto.domain.constants.LottoConstraint.*;

public enum ExceptionMessage {
    EXCEPTION_MESSAGE_PREFIX("[ERROR] "),
    NUMBER_FORMAT_EXCEPTION(LOTTO_PRICE.getValue() +
            "원 단위의 숫자를 입력해 주세요. 최소 금액은 " +
            LOTTO_PRICE.getValue() + "원 입니다."),
    BONUS_NUMBER_FORMAT_EXCEPTION(NUMBER_RANGE_MINIMUM.getValue() + "~" +
            NUMBER_RANGE_MAXIMUM.getValue() + "범위의 숫자를 입력해 주세요."),
    LOTTERY_NUMBER_FORMAT_EXCEPTION(NUMBER_RANGE_MINIMUM.getValue() + "~" +
            NUMBER_RANGE_MAXIMUM.getValue() + "범위의 서로 다른 " + NUMBER_COUNT.getValue() +
            "개의 숫자를 \",\"로 구분해 입력해 주세요."),
    BONUS_NUMBER_DUPLICATES_EXCEPTION("보너스 번호는 당첨 번호와 서로 달라야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
