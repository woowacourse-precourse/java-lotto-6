package lotto.util;

import static lotto.util.Constants.LOTTO_ONE_GAME_PRICE;

public enum ExceptionMessage {
    INVALID_UNIT_OF_BUDGET(String.format("금액은 %d원 단위로 입력해야 합니다.", LOTTO_ONE_GAME_PRICE)),
    INVALID_INPUT_NUMERIC("입력값은 숫자만 들어올 수 있습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }

}
