package lotto.message;

import static lotto.constants.SystemOption.PAYMENT_UNIT_VALUE;
import static lotto.constants.SystemOption.TARGET_NUMBERS_SIZE_VALUE;

public enum ErrorMessage {
    NOT_NUMBER_ERROR_MESSAGE("[ERROR] 올바른 숫자 형식으로 입력해주세요."),
    NOT_POSITIVE_ERROR_MESSAGE("[ERROR] 양수 값을 입력해주세요."),
    WRONG_RANGE_ERROR_MESSAGE("[ERROR] 1 이상 45 이하의 수를 입력해주세요."),
    DUPLICATE_ERROR_MESSAGE("[ERROR] 중복된 수가 입력되었습니다."),
    DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE("[ERROR] 이미 당첨 번호에 존재하는 수가 입력되었습니다."),
    WRONG_NUMBERS_SIZE_ERROR_MESSAGE(String.format("[ERROR] 숫자를 %d 개 입력해주세요",
            TARGET_NUMBERS_SIZE_VALUE.getValue())),
    WRONG_UNIT_ERROR_MESSAGE(String.format("[ERROR] %d 단위로 금액을 입력해주세요",
            PAYMENT_UNIT_VALUE.getValue()));

    private String content;

    ErrorMessage(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
