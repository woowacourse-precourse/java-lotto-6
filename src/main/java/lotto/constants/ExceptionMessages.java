package lotto.constants;

import java.util.Objects;

public enum ExceptionMessages {
    ERROR("[ERROR] "),
    INVALID_NUMBER_BUY_AMOUNT("구매 금액은 숫자 형식 입력만 가능합니다."),

    INVALID_ZERO_BUY_AMOUNT("구매 금액은 1,000원 단위로 입력하여야 합니다."),

    INVALID_BLANK_BUY_AMOUNT("구매 금액은 공백이 아닌 1,000원 단위로 입력하여야 합니다."),

    INVALID_REMAINDER_NUMBER("구매 금액은 1,000원 단위로 나누어 떨어져야 합니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        if (ERROR.message.equals(message)) {
            return this.message;
        }
        return ERROR.message + message;
    }

}
