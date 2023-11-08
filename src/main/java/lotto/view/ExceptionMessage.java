package lotto.view;

import lotto.utils.Constants;

public enum ExceptionMessage {
    NOT_INTEGER_ERROR("[ERROR] 숫자만 입력해 주세요."),
    NOT_NATURAL_NUMBER_ERROR("[ERROR] 숫자는 0 초과이어야 합니다."),
    NOT_DIVISIBLE_NUMBER_ERROR("[ERROR] 금액은 " + Constants.LOTTO_TICKET_PRICE + "단위여야 합니다."),
    NOT_IN_RANGE_ERROR("[ERROR] 번호는 1-45 사이여야합니다."),
    DUPLICATE_NUMBER_ERROR("[ERROR] 숫자는 모두 달라야합니다"),
    INVALID_FORMAT_ERROR("[ERROR] 입력 형식이 잘못 되었습니다"),
    INVALID_NUMBER_COUNT("[ERROR] 당첨 번호는 6개여야합니다");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}